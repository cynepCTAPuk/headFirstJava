//: io/DirectoryDemo.java
// Sample use of Directory utilities.
package chap18_io;
import java.io.*;
import util.*;
import static util.Print.*;
public class DirectoryDemo {
    public static void main(String[] args) {
        // All directories:
//        PPrint.pprint(Directory.walk(".").dirs);
        print("-*-*-*-*-*-*-*-*-*-*-*-");

        // All files in root beginning with ‘T’
        for(File file : Directory.local(".", "T.*")) print(file);
        print("----------------------");

        // All Java files recursively beginning with ‘T’:
        for(File file : Directory.walk(".", "T.*\\.java")) print(file);
        print("======================");

        // Class files recursively containing "Z" or "z":
        for(File file : Directory.walk(".",".*[Zz].*\\.class")) print(file);
    }
} /* Output: (Sample)
[.\xfiles]
.\TestEOF.class
.\TestEOF.java
.\TransferTo.class
.\TransferTo.java
----------------------
.\TestEOF.java
.\TransferTo.java
.\xfiles\ThawAlien.java
======================
.\FreezeAlien.class
.\GZIPcompress.class
.\ZipCompress.class
*///:~