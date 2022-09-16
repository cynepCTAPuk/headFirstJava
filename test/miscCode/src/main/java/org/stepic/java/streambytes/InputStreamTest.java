package org.stepic.java.streambytes;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
    public static void main(String[] args) {
//        System.out.println(InputStreamTest.class.getResource("InputStreamTest.class"));
//        System.out.println(InputStreamTest.class.getName());
        try (InputStream inputStream =
                     InputStreamTest.class.getResourceAsStream("InputStreamTest.class")) {
            int read = inputStream.read();
            while (read >= 0) {
                System.out.printf("%02x", read);
//                System.out.print((char)read);
                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
