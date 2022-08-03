package in_out;

import java.io.*;

public class FileCopy3 {
    public static void main(String[] args) {
        String source = "c:/000/1.txt";
        String destination = "c:/000/2.txt";

        try (InputStream fis = new FileInputStream(source);
             OutputStream fos = new FileOutputStream(destination)) {

            if (fis.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[fis.available()];
                int count = fis.read(buffer);
                fos.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}