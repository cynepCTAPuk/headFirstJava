//: chap18_io/Exercise12.java
package chap18_io;
import java.io.*;
import java.util.*;

public class Exercise12 {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String file;
        PrintWriter out;
        if (args.length == 2) {
            file = read(args[0]);
            out = new PrintWriter(args[1]); // Here’s the shortcut:
        } else {
            file = read("chap18_io/Exercise12.java");
            out = new PrintWriter("c://000/Exercise12.out"); // Here’s the shortcut:
        }

        List list = Arrays.asList(file.split("\n"));
        int i = 0;
        for (Object o : list) {
            ++i;
            out.print(i + " " + o + "\n");
            System.out.print(i + " " + o + "\n");
        }
        out.close();
    }
} /* (Execute to see output) *///:~