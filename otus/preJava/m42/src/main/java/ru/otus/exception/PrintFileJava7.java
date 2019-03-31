package ru.otus.exception;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class PrintFileJava7 {
    private static void printFileJava7_1() {
        try (FileInputStream fileInputStream = new FileInputStream("file.txt")) {
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fileInputStream.read();
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
    private static void printFileJava7_2(){
        try (FileInputStream fileInputStream = new FileInputStream("file.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = bufferedInputStream.read();
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printFileJava7_1();
        System.out.println("\n-------------------------");
        printFileJava7_2();
    }
}
