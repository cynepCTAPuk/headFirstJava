//: io/FormattedMemoryInput.java
package chap18_io;

import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        String file = "chap18_io/FormattedMemoryInput.java";
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream( BufferedInputFile.read( file).getBytes()));
            while (true) System.out.print((char) in.readByte());
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
} /* (Execute to see output) *///:~