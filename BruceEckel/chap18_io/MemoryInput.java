//: io/MemoryInput.java
package chap18_io;

import java.io.*;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read(
                        "chap18_io/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) System.out.print((char) c);
    }
} /* (Execute to see output) *///:~