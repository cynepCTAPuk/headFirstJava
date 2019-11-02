package com.example;

public class PrintTest {
    public static void main(String[] args) {
        System.out.println("com.example.PrintTest.main");
        System.out.println("args = " + args);
        System.out.printf("printf %,d\n", 1_000);
        System.err.println("com.example.PrintTest");
    }
}
