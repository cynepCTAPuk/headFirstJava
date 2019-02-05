//: io/BufferedInputFile.java
package chap18_io;

import java.io.*;
import java.util.*;

public class Exercise8 {
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
        String file;
        if (args.length > 0) file = read(args[0]);
        else file = read("chap18_io/Exercise8.java");
        LinkedList list = new LinkedList(Arrays.asList(file.split("\\n")));
//        ListIterator it = list.listIterator(list.size());
//        while(it.hasPrevious()) System.out.println(it.previous());
        while (!list.isEmpty()) System.out.println(list.removeLast());
    }
} /* (Execute to see output) *///:~