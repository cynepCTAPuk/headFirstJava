//: io/Echo.java
// How to read from standard input.
// {RunByHand}
package chap18_io;
import java.io.*;
public class Exercise21 {
    public static void main(String[] args) throws IOException {
        String s;
        String file = "chap18_io/Exercise21.java";
        if (args.length == 1) {
            BufferedReader stdin = new BufferedReader(new FileReader(args[0]));
            while ((s = stdin.readLine()) != null) {
                System.out.println(s.toUpperCase());
            }
        } else {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            // An empty line or Ctrl-Z terminates the program
            while ((s = stdin.readLine()) != null && s.length() != 0)
                System.out.println(s.toUpperCase());
        }
    }
} ///:~