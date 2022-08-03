package web.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//        getSite(new URL("http://javarush.ru/social.html"));
        getSite(new URL("https://time.com"));
    }

    public static void getSite(URL url) {
        try {

            String protocol = url.getProtocol();
            String host = url.getHost();
//            String path = url.getPath();
            String path = url.getFile();

            Socket socket = new Socket(url.getHost(), 80);

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(outputStream);
            String write =
                    "GET "
//                            + path + " "
                            + protocol + "/1.1"
                            + "\r\n"
//                            + "Host: "
//                            + host
                            + "\r\n"
                    ;
            System.out.println(write);
            out.write(write);
            out.flush();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader input = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(input);
            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}