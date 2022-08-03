package org.stepic.java.streambytes;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class InputStreamTest4 {
    public static void main(String[] args) throws IOException {
//        byte[] data = {0x33, 0x45, 0x01};
//        byte[] data = new byte[]{48, 49, 50, 51};
        byte[] data = new byte[]{48, 49, 50, 51};
//        data ="Привет Мир!\nHello World!".getBytes();
        Charset charset = StandardCharsets.UTF_8;
//        charset = StandardCharsets.US_ASCII;

        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            System.out.println(readAsString(inputStream, charset));
        }
    }

public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
    Reader reader = new InputStreamReader(inputStream, charset);
    try (StringWriter stringWriter = new StringWriter()) {
        int data;
        while ((data = reader.read()) != -1) {
            stringWriter.write(data);
        }
        return stringWriter.toString();
    }
}

    public static void write(InputStream inputStream) throws IOException {
        int read;
        while ((read = inputStream.read()) >= 0) {
            System.out.print((char) read);
        }
        System.out.println();
    }
}
