//: chap18_io/Exercise10.java
package chap18_io;
import java.io.*;
import java.util.*;

public class Exercise10 {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) sb.append(s).append("\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String [] words;
        if (args.length > 1) {
            words = new String[args.length];
            for (int i = 0; i < args.length; i++) words[i] = args[i];
        } else words = new String[]{"chap18_io/Exercise10.java", "public", "while"};

        String file = read(words[0]);
        LinkedList list = new LinkedList(Arrays.asList(file.split("\\n")));

        while (!list.isEmpty()) {
            String s = String.valueOf(list.poll());
            for (int i = 1; i < words.length; i++) {
                String word = words[i];
                if (s.contains(word)) {
                    System.out.println(s);
                    break;
                }
            }
        }
    }
} /* (Execute to see output) *///:~