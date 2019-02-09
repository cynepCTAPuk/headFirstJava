//: io/GZIPcompress.java
// {Args: GZIPcompress.java}
package chap18_io;

import java.util.zip.*;
import java.io.*;

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: \nGZIPcompress file\n" +
                    "\tUses GZIP compression to compress " +
                    "the file to c:/000/test.gz");
            System.exit(1);
        }
        String file = args[0];
        String zipFile = "c:/000/test.gz";

        BufferedReader in = new BufferedReader(new FileReader(file));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(new FileOutputStream(zipFile)));

        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) out.write(c);
        in.close();
        out.close();

        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(
                        new FileInputStream(zipFile))));
        String s;
        while ((s = in2.readLine()) != null) System.out.println(s);

        System.out.println("Reading Zip file");
        BufferedReader in3 = new BufferedReader( new FileReader(zipFile));
        String s1;
        while ((s1 = in3.readLine()) != null) System.out.println(s1);
    }
} /* (Execute to see output) *///:~