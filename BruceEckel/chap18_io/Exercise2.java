package chap18_io;

import java.io.*;
import java.util.*;

public class Exercise2 {
    static File[] printDirs(String dir) {
        File path = new File(dir);
        File[] list = path.listFiles();
        Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {
                System.out.printf("[%-26s] ", list[i].getName());
                if (i % 3 == 2) System.out.println();
            }
        }
        System.out.println();
//        printFiles(dir);
        return list;
    }

    static void printFiles(String dir) {
        File path = new File(dir);
        File[] list = path.listFiles();
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile()) {
                System.out.printf("%-20s ", list[i].getName());
                System.out.printf("%,6d \n", list[i].length());
                System.out.printf("%s \n", list[i].getAbsolutePath());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String dir = "C://";
        printDirs(dir);
    }
}
