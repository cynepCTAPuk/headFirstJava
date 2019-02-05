package chap18_io;

import java.io.*;

public class Exercise2a {
    public static void main(String[] args) {
        File dir = new File("C://V//");
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) { System.out.println(item.getName() + "  \t folder");
                } else { System.out.println(item.getName() + "\t newFile"); }
            }
        }
    }
}