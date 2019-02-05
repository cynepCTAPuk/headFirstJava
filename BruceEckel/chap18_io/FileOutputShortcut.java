//: io/FileOutputShortcut.java
package chap18_io;

import java.io.*;

public class FileOutputShortcut {
    static String newFile = "c:/000/FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        String readFile = "chap18_io/FileOutputShortcut.java";
        BufferedReader in = new BufferedReader(
                new StringReader( BufferedInputFile.read(readFile)));
        PrintWriter out = new PrintWriter(newFile); // Here’s the shortcut:
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored newFile:
        System.out.println(BufferedInputFile.read(newFile));
    }
} /* (Execute to see output) *///:~