package org.stepic.java.streambytes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputStreamTest3 {
    public static void main(String[] args) throws IOException {
//        byte[] data = {0x33, 0x45, 0x01};
        byte[] data = "Hello\r\nWorld!".getBytes();
        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            write(inputStream);
        }
        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            System.out.println(checkSumOfStream(inputStream));
        }
    }

    public static void write(InputStream inputStream) throws IOException {
        int read;
        while ((read = inputStream.read()) >= 0) {
//            System.out.print((char) read);
            System.out.printf("%d ",read);
        }
        System.out.println();
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int ctrlSum = 0;
        int read;
        while ((read = inputStream.read()) >= 0) {
            ctrlSum = Integer.rotateLeft(ctrlSum, 1) ^ read;
        }
        return ctrlSum;
    }
}
