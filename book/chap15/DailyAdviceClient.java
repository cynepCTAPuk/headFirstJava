package book.chap15;

import java.io.*;
import java.net.Socket;

public class DailyAdviceClient {
    String host = "127.0.0.1";
    int port = 4242;
    String messageIn; // Подготавливаем строку для ответа

    public void go() {
        try {
            Socket socket = new Socket(host, port); // default port: 4242
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((messageIn = bufferedReader.readLine()) != null) {
                System.out.println(messageIn); // Печатаем ответ от сервера на консоль
            } // end loop while
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } // end method go()

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    } // end main
} // end class DailyAdviceClient
