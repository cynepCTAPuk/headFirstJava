package chap18_io;

import util.*;

import java.io.*;
import java.util.*;

public class Exercise20 {
    public static void main(String[] args) throws IOException {
        File[] files = Directory.local("c:/000/", ".*class");
        System.out.println(Arrays.toString(files));
        for (File f : files) {
//            RandomAccessFile raf = new RandomAccessFile(f, "r");
//            for (int i = 0; i < 9; i++) System.out.printf("%4d",raf.read());

            byte[] bytes = BinaryFile.read(f);
            for (int i = 0; i < 9; i++) System.out.printf("%4d", bytes[i]);

            System.out.println();
        }
        String s = "CAFE-BABY";
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) System.out.printf("%4c", cs[i]);
    }
}

