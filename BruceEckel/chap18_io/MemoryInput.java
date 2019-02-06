//: io/MemoryInput.java
package chap18_io;
import java.io.*;
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        String file = "chap18_io/MemoryInput.java";
        StringReader in = new StringReader( BufferedInputFile.read( file));
        int c;
        while ((c = in.read()) != -1) System.out.print((char) c);
    }
} /* (Execute to see output) *///:~