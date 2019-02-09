//: io/ZipCompress.java
// Uses Zip compression to compress any number of files given on the command line.
// {Args: ZipCompress.java}
package chap18_io;

import java.util.zip.*;
import java.io.*;
import java.util.*;

import static util.Print.*;

public class ZipCompress {
    public static void main(String[] args) throws IOException {
        String fileZip = "c:/000/test.zip";
        FileOutputStream fos = new FileOutputStream(fileZip);
        CheckedOutputStream csumo = new CheckedOutputStream(fos, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csumo);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");
        // No corresponding getComment(), though.

        for (String arg : args) {
            print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c = in.read()) != -1) out.write(c);
            in.close();
            out.flush();
        }
        out.close();

        // Checksum valid only after the file has been closed!
        print("Checksum: " + csumo.getChecksum().getValue());

        // Now extract the files to console:
        FileInputStream fis = new FileInputStream(fileZip);
        CheckedInputStream csumi = new CheckedInputStream(fis, new Adler32());
        ZipInputStream zis = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(zis);
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            print("\nReading file " + ze);
            int x;
            while ((x = bis.read()) != -1) System.out.write(x);
        }
        if (args.length == 1)
            print("Checksum: " + csumi.getChecksum().getValue());
        bis.close();

        // Alternative way to open and read Zip files:
        ZipFile zf = new ZipFile(fileZip);
        Enumeration e = zf.entries();
        print();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            print("File: " + ze2);
            // ... and extract the data as before
        }
        /* if(args.length == 1) */
    }
} /* (Execute to see output) *///:~