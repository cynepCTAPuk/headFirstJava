//: io/BasicFileOutput.java
package chap18_io;
import java.io.*;
public class BasicFileOutput {
    static String newFile = "c://000/BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        String readFile = "chap18_io/BasicFileOutput.java";
        BufferedReader in = new BufferedReader(
                new StringReader( BufferedInputFile.read(readFile)));
        PrintWriter out = new PrintWriter( new BufferedWriter(new FileWriter(newFile)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored newFile:
        System.out.println(BufferedInputFile.read(newFile));
    }
} /* (Execute to see output) *///:~