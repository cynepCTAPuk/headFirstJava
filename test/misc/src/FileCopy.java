package src;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("c:/000/data.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("c:/000/result1.txt");

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}