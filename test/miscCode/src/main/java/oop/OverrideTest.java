package oop;

public class OverrideTest {
    public static void print(int n) {
        System.out.println("int: " + n);
    }

    public static void print(short n) {
        System.out.println("short: " + n);
    }

    public static void print(Integer n) {
        System.out.println("Integer: " + n);
    }

    public static void print(String s) {
        System.out.println("String: " + s);
    }

    public static void main(String[] args) {
        OverrideTest.print(1);
        OverrideTest.print((byte) 2);
        OverrideTest.print("3");
        OverrideTest.print((Integer) null);
        OverrideTest.print((String) null);
    }
}
