package puzzle_41;

import java.io.*;

public class Copy1 {
    static void copy(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) out.write(buf, 0, n);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) { // There is nothing we can do if close fails
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) { // Again, there is nothing we can do if close fails
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
/*
        if (args.length != 2) System.out.println("Usage: java Copy <source> <dest>");
        else copy(args[0], args[1]);
*/
        copy("c:/000/11.txt", "c:/000/2.txt");
    }
}
