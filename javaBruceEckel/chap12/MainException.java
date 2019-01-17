//: exceptions/MainException.java
package chap12;
import java.io.*;
public class MainException {
    // Pass all exceptions to the console:
    public static void main(String[] args) throws Exception {
        // Open the file:
        FileInputStream file = new FileInputStream("chap12/MainException.java");
        // Use the file ...
        // Close the file:
        file.close();
    }
} ///:~