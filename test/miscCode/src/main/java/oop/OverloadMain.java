package oop;

public class OverloadMain {
    public static void main(String[] args) {
        System.out.println("Hi from main");
        OverloadMain.main("Java");
    }

    public static void main(String arg1) {
        System.out.println("Hi, " + arg1);
        OverloadMain.main("Dear Java", "My Java");
    }

    public static void main(String arg1, String arg2) {
        System.out.println("Hi, " + arg1 + ", " + arg2);
    }
}
