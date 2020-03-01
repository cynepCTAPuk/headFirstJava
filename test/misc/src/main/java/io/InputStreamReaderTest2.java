package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest2 {
    public static void main(String[] args) throws IOException {
//        String file = "C:/000/source.txt";
        String file = "src/main/java/inout/InputStreamReaderTest2.java";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            System.out.print(bufferedReader.readLine());
            if(!bufferedReader.ready()) break;
            System.out.print(" ");
        }
    }
}
