package io;

import java.io.*;

public class FileTest1 {
    public static void main(String[] args) {
        InputStream fis = null;
        try {
            fis = new FileInputStream("io/FileTest1.java");
            while (true) {
                int c = fis.read();
                if(c == -1) break;
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("catch FileNotFoundException");
        } catch (IOException e) {
            System.out.println("catch IOException try");
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
                System.out.println("catch IOException finally");
            }
        }
    }
}
