package inOut;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String source = "c:/000/source.txt";
        String destination = "c:/000/new/new/destination.txt";

        new File(destination).getParentFile().mkdirs();

        try (InputStream fileInputStream = new FileInputStream(source);
             OutputStream fileOutputStream = new FileOutputStream(destination)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}