package exceptions.task3806;

/* 
Улучшения в Java 7 (try-with-resources)
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public void printFile1() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream("c:/000/1.txt")) {
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = fileInputStream.read();
            }
        }
    }

    public void printFile2() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("c:/000/2.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = bufferedInputStream.read();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().printFile1();
        System.out.println("-".repeat(30));
        new Solution().printFile2();
    }
}