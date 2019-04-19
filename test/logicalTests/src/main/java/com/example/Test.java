package com.example;

public class Test {
    private static Boolean b1, b2;

    public static void main(String[] args) {
        if (b1 || !b2 || !b1 || b2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
/*
Exception in thread "main" java.lang.NullPointerException
	at com.example.Test.main(Test.java:7)
 */
