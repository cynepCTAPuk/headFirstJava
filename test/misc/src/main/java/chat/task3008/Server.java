package chat.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение для " + entry.getKey() + " не удалось отправить");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введи порт: ");
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        try {
            while (true) {
                System.out.println("Сервер запущен");
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(e.toString());
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            MessageType messageType;
            String userName;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                messageType = message.getType();
                userName = message.getData();
                if (messageType == MessageType.USER_NAME && !userName.equals("")
                        && !connectionMap.containsKey(userName)) {
                    connectionMap.put(userName, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return userName;
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    Message message = new Message(MessageType.USER_ADDED, entry.getKey());
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            MessageType messageType;
            String text;
            while (true) {
                message = connection.receive();
                messageType = message.getType();
                if (messageType == MessageType.TEXT) {
                    text = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(messageType, text));
                } else ConsoleHelper.writeMessage("Данное сообщение не текст");
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            String userName = "";
            try {
                Connection connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом <"
                        + userName + ">");
            } finally {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным адресом <" + userName + "> закрыто");
            }
        }
    }
}
