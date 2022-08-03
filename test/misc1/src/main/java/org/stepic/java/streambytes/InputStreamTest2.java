package org.stepic.java.streambytes;

import org.stepic.java.file.FilePath;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputStreamTest2 {
    public static void main(String[] args) {
//        System.out.println(InputStreamTest.class.getResource("InputStreamTest.class"));
//        System.out.println(InputStreamTest.class.getName());
        Path path = Paths.get("src/main/java/"
                + FilePath.class.getPackage().getName().replace('.', '/')
                + "/InputStreamTest2.java");
        try (InputStream inputStream = Files.newInputStream(path)) {
//        try (InputStream inputStream = new FileInputStream(String.valueOf(path))) {
//        try (InputStream inputStream = new FileInputStream(path.toFile())) {
            int read = inputStream.read();
            while (read >= 0) {
//                System.out.printf("%02x", read);
                System.out.print((char) read);
                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
