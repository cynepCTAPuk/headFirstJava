package chap08.tree;

import java.io.*;
import java.util.*;

public class GenerateString {
    public static void main(String[] args) throws FileNotFoundException {
        new GenerateString().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = null;
        printWriter = new PrintWriter("C:/000/input.txt");


        int n = 10_000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            printWriter.print((char) ('a' + random.nextInt(26)));
        }
        printWriter.close();
    }
}
