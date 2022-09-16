package oop;

class Details {
    static int x = 100;
    {
        System.out.print("Welcome ");
    }
}

public class StaticBlock {
    {
        System.out.print("Hello ");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oop.Details");
        System.out.println("Test");
    }
}

