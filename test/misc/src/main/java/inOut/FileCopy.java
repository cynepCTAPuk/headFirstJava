package inOut;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
    public static void main(String[] args) {
        String source = "c:/000/source.txt";
        String destination = "c:/000/destination.txt";
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