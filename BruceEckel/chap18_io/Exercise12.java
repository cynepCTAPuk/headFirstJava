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

    public static String write(String filename, String text) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String file;
        if (args.length > 0) file = read(args[0]);
        else file = read("chap18_io/Exercise12.java");

        LinkedList list = new LinkedList(Arrays.asList(file.split("\\n")));
        int i = 0;
        while (!list.isEmpty()) {
            System.out.printf("%-2d %s\n", ++i, list.poll());
        }
    }
} /* (Execute to see output) *///:~