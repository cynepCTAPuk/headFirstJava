//: io/ChangeSystemOut.java
// Turn System.out into a PrintWriter.
package chap18_io;
import java.io.*;
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }
} /* Output:
Hello, world
*///:~