package chap18_io;

import java.io.*;

public class Exercise2 {
    static String[] printDirs(String dir) {
        File path = new File(dir);
        String[] list = path.list();
        for (int i = 0; i < list.length; i++) {
            File file = new File(list[i]);
            if (file.isDirectory()) {
                System.out.printf("[%-22s] ", list[i]);
                if (i % 3 == 2) System.out.println();
            }
        }
        System.out.println();
        printFiles(dir);
        return list;
    }

    static void printFiles(String dir) {
        File path = new File(dir);
        String[] list = path.list();
        for (int i = 0; i < list.length; i++) {
            File file = new File(list[i]);
            if (file.isFile()) {
                System.out.printf("%-20s ", file.getName());
                System.out.printf("%,6d \n", file.length());
                System.out.printf("%s \n", file.getAbsolutePath());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String dir = "C://";
        printDirs(dir);
    }
}
