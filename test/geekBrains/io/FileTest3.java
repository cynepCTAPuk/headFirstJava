/* 1231237890*/
package io;

import java.io.*;
import java.util.*;

public class FileTest3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("io/FileTest3.java", "rw");
        raf.seek(3);
        byte[] bytes = new byte[3];
        raf.read(bytes, 0, 3);
        raf.write(bytes);
        System.out.println(Arrays.toString(bytes));
        raf.seek(raf.length());
        raf.write("/* end of file */\n".getBytes());
        raf.close();

        for (int i = 65; i < 65 + 26 ; i++) System.out.print((char) i + " ");
    }
}
/* end of file */
/* end of file */
