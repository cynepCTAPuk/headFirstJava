package inOut;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
    public static void main(String[] args) {

        try (
                InputStream fileInputStream = new FileInputStream("c:/000/data.txt");
                OutputStream fileOutputStream = new FileOutputStream("c:/000/result1.txt")) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}