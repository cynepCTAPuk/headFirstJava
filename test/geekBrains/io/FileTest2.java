package io;

import java.io.*;

public class FileTest2 {
    public static void main(String[] args) {
        try(InputStream fis = new FileInputStream("io/FileTest2.java")) {
            while (true) {
                int c = fis.read();
                if (c == -1) break;
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("catch FileNotFoundException");
        } catch (IOException e) {
            System.out.println("catch IOException try");
        }
    }
}
