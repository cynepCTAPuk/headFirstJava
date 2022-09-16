package web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        //создаем объект сервер-сокет
        ServerSocket serverSocket = new ServerSocket(4444); //порт

        //в цикле обрабатываем входящие соединения.
        boolean work = true;
        while (work) {
            //метод accept ждет, пока кто-то не подключится.
            Socket socket = serverSocket.accept();

            //читаем сообщение
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String message = in.readLine();
            if (message.equalsIgnoreCase("exit")) {
                work = false;
            } else {
                //придумываем ответ – просто разворачиваем строку задом наперед
                String reverseMessage = new StringBuilder(message).reverse().toString();

                //отправляем ответ
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);
                out.println(reverseMessage);
//                out.flush();
            }
        }
    }
}
