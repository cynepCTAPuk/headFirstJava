package oop;

public class OverloadTest1 {
    public static void print(Object o) {
        System.out.println("Object: " + o);
    }

    public static void print(String s) {
        System.out.println("String: " + s);
    }

    public static void main(String[] args) {
        OverloadTest1.print(1);
        OverloadTest1.print((byte) 2);
        OverloadTest1.print("3");
        OverloadTest1.print((Integer) null);
        OverloadTest1.print(null);
    }
}
