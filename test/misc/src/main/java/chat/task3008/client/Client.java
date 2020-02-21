package chat.task3008.client;

import chat.task3008.Connection;
import chat.task3008.ConsoleHelper;
import chat.task3008.Message;
import chat.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Введи адрес сервера: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введи порт сервера: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        ConsoleHelper.writeMessage("Введи имя: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            System.out.println("Нет соединения");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                this.wait();
                if (clientConnected) ConsoleHelper.writeMessage(
                        "Соединение установлено.\nДля выхода наберите команду 'exit'.");
                else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
                while (clientConnected) {
                    String text = ConsoleHelper.readString();
                    if (text.equalsIgnoreCase("exit") || !clientConnected) break;
                    if (shouldSendTextFromConsole()) sendTextMessage(text);
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Что-то пошло не так");
            }
        }
    }

    public static void main(String[] args) {
        new Client().run();
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notifyAll();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            boolean isNameAccepted = false;
            while (!isNameAccepted) {
                Message message = connection.receive();
                MessageType messageType = message.getType();
                if (messageType == null) throw new IOException("Unexpected MessageType");
                switch (messageType) {
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        isNameAccepted = true;
                        break;
                    case NAME_REQUEST:
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                MessageType messageType = message.getType();
                if (messageType == null) throw new IOException("Unexpected MessageType");
                String data = message.getData();
                switch (messageType) {
                    case TEXT:
                        processIncomingMessage(data);
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(data);
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(data);
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        @Override
        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage(e.toString());
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
