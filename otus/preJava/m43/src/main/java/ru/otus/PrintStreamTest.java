package ru.otus;

import java.io.PrintStream;
import java.util.Date;

public class PrintStreamTest {
    public static void main(String[] args) {
        int var = 5;
        Date now = new Date();
        System.out.println(var);
        System.out.println(now);

        PrintStream ps = System.out;
        ps.println(var);
        ps.println(now);
    }
}
