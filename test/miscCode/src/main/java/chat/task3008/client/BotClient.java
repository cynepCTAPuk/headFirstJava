package chat.task3008.client;

import chat.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. " +
                    "Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] msg = message.split(":");
            if (!message.contains(":") || msg.length != 2) return;

            String[] strings = {"дата", "день", "месяц", "год", "время", "час", "минуты", "секунды"};
            String[] formats = {"d.MM.YYYY", "d", "MMMM", "YYYY", "H:mm:ss", "H", "m", "s"};
            for (int i = 0; i < strings.length; i++) {
                String string = msg[1].trim();
                if (string.equals(strings[i])) {
                    String userName = msg[0];
                    String result = new SimpleDateFormat(formats[i])
                            .format(Calendar.getInstance().getTime());
                    sendTextMessage("Информация для " + userName + ": " + result);
                    break;
                }
            }
        }
    }
}
