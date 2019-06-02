package puzzle_41;

import java.io.*;

public class Copy3 {
    static void copy(String src, String dest) throws IOException {
        try (FileInputStream in = new FileInputStream(src)) {
            try (FileOutputStream out = new FileOutputStream(dest)) {
                byte[] buf = new byte[1024];
                int n;
                while ((n = in.read(buf)) > 0) out.write(buf, 0, n);
//                out.write(new byte[]{Byte.valueOf(" "), 66}, 0, 2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        if (args.length != 2) System.out.println("Usage: java Copy <source> <dest>");
//        else copy(args[0], args[1]);
        copy("c:/000/40.txt", "c:/000/41.txt");
    }
}
