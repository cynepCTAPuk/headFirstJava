//: chap18_io/Exercise7.java
package chap18_io;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Exercise10 {
    // Throw exceptions to console:
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String file = read("chap18_io/Exercise7.java");
        String find = "public";
        LinkedList list = new LinkedList(Arrays.asList(file.split("\\n")));
        while(!list.isEmpty()) {
            String s = String.valueOf(list.poll());
            if(s.contains(find)) System.out.println(s);
        }
    }
} /* (Execute to see output) *///:~