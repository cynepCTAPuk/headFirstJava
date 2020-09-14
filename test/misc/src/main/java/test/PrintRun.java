package test;

public class PrintRun {
    static String string = "Hello";

    public static void main(String[] args) {
        System.out.println(PrintRun.string);
        Test.calc();
    }

    static void check() {

    }
}

class Test {
    static void calc() {
        PrintRun.check();
        System.out.println("Мы тут развлекаемся!");
    }
}