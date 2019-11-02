package com.example;

public class CompareTest {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Integer a, b;
        int z1 = 127;
        int z2 = -128;

        a = z1;
        b = z1;
        System.out.println(z1 + " - " + (a == b) + " " + a.compareTo(b));

        a = z2;
        b = z2;
        System.out.println(z2 + " - " + (a == b) + " " + a.compareTo(b));

        a = new Integer(z1);
        b = new Integer(z1);
        System.out.println(z1 + " - " + (a == b) + " " + a.compareTo(b));
    }
}
