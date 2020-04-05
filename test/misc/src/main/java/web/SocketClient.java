package web;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        //создаем сокет
        Socket clientSocket = new Socket("localhost", 4444);

        //отправляем строку в OutputStream
        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println("Kiss my shiny metal ass!");
//        out.println("exit");
//        out.flush();

        //читаем ответ
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String answer = in.readLine();
            System.out.println(answer);
        } catch (SocketException e) {
            System.out.println("Server interrupted connection!");
        }
    }
}
