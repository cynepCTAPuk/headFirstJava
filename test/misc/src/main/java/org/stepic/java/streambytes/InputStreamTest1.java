package org.stepic.java.streambytes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class InputStreamTest1 {
    public static final String S = File.separator;

    public static void main(String[] args) {
        String host = "ya.ru";
        host = "dateandtime.com";
        try (Socket socket = new Socket(host, 80)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(("GET / HTTP"
                    + "/1.1"
                    + "\r\n\r\n").getBytes());
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read();
            while (read >= 0) {
                System.out.print((char) read);
                read = inputStream.read();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
