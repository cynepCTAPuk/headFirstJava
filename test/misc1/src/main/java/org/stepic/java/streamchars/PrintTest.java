package org.stepic.java.streamchars;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintTest {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("Hello World!","UTF-8");

        PrintStream printStream = new PrintStream(System.out);
    }
}
