package oop;

public class OverloadTest {
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
        OverloadTest.print(1);
        OverloadTest.print((byte) 2);
        OverloadTest.print("3");
        OverloadTest.print((Integer) null);
        OverloadTest.print((String) null);
    }
}
