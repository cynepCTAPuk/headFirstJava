//: io/TestEOF.java
// Testing for end of file while reading a byte at a time.
package chap18_io;

import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("chap18_io/TestEOF.java")));
        while (in.available() != 0) System.out.print((char) in.readByte());
    }
} /* (Execute to see output) *///:~