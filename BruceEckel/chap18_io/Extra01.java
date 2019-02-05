//: io/BasicFileOutput.java
package chap18_io;
import java.io.*;
public class Extra01 {
    public static void main(String[] args) throws IOException {
        String readFile = "chap18_io/Extra01.java";
        System.out.println(BufferedInputFile.read(readFile));
    }
} /* (Execute to see output) *///:~