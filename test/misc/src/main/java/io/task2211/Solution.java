package io.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
//            System.out.println("Solution source destination");
        } else {
            String source = args[0];
            String destination = args[1];
            Charset windows1251 = Charset.forName("Windows-1251");
            Charset utf8 = StandardCharsets.UTF_8;
            try (InputStream inputStream = new FileInputStream(source);
                 OutputStream outputStream = new FileOutputStream(destination)) {
                if (inputStream.available() > 0) {
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    String s = new String(buffer, windows1251);
                    buffer = s.getBytes(utf8);
                    outputStream.write(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
