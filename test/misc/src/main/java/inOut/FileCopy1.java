package inOut;

import java.io.*;

public class FileCopy1 {
    public static void main(String[] args) {
        String source = "c:/000/1.txt";
        String destination = "c:/000/2.txt";

        try (InputStream fileInputStream = new FileInputStream(source);
             OutputStream fileOutputStream = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1_000];
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}