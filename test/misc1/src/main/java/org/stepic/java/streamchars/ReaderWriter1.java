package org.stepic.java.streamchars;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReaderWriter1 {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("in.txt");
        Writer writer = new FileWriter("out.txt");

        Reader reader1 = new InputStreamReader(new FileInputStream("in.txt"),
                StandardCharsets.UTF_8);
        Writer writer1 = new OutputStreamWriter(new FileOutputStream("out.txt"),
                StandardCharsets.UTF_8);

        Reader reader2 = new CharArrayReader(new char[]{'h', 'e', 'l', 'l', 'o'});

        CharArrayWriter writer2 = new CharArrayWriter();
        writer2.write("Test");
        char[] resultArray = writer2.toCharArray();

        Reader reader3 = new StringReader("hello");

        StringWriter writer3 = new StringWriter();
        writer3.write("Test");
        String resultString = writer3.toString();
    }
}
