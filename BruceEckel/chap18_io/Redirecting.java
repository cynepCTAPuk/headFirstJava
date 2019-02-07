//: io/Redirecting.java
// Demonstrates standard I/O redirection.
package chap18_io;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        String inFile = "chap18_io/Redirecting.java";
        String outFile = "c:/000/test.out";

        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close(); // Remember this!
        System.setOut(console);
    }
} ///:~