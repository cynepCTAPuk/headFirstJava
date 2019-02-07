//: io/Echo.java
// How to read from standard input.
// {RunByHand}
package chap18_io;
import java.io.*;

public class Exercise21 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s;
        while((s = stdin.readLine()) != null && s.length()!= 0)
            System.out.println(s.toUpperCase());
        // An empty line or Ctrl-Z terminates the program
    }
} ///:~