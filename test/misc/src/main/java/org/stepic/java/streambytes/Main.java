package org.stepic.java.streambytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        try (InputStream inputStream = System.in; OutputStream outputStream = System.out) {
            int data;
            int current;
            while ((data = inputStream.read()) != -1) {
                current = data;
                if (current == '\r') {
                    data = inputStream.read();
                    if (data == -1) {
                        outputStream.write(current);
                        outputStream.flush();
                        break;
                    } else if (data == '\n') {
                        outputStream.write('\n');
                    } else {
                        outputStream.write(current);
                        outputStream.write(data);
                    }
                } else {
                    outputStream.write(current);
                }
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
