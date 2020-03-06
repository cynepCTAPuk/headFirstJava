package oop;

public class OverrideTest1 {
    public static void print(Object o) {
        System.out.println("Object: " + o);
    }

    public static void print(String s) {
        System.out.println("String: " + s);
    }

    public static void main(String[] args) {
        OverrideTest1.print(1);
        OverrideTest1.print((byte) 2);
        OverrideTest1.print("3");
        OverrideTest1.print((Integer) null);
        OverrideTest1.print(null);
        OverrideTest1.print( null);
    }
}
