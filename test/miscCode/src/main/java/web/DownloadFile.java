package web;
/**
 * https://javarush.ru/quests/lectures/questcollections.level10.lecture03
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class DownloadFile {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com.ua/images/srpr/logo11w.png");
        URLConnection connection = url.openConnection(); //устанавливаем соединение

        //получаем OutputStream, чтобы писать в него данные запроса
/*
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(1);
        outputStream.flush();
*/

        //получаем InputStream, чтобы читать из него данные ответа
        InputStream inputStream = connection.getInputStream();
        Files.copy(inputStream, new File("c:/000/google.png").toPath());
    }
}
