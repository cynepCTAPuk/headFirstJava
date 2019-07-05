package ru.otus.jmm;

public class Foo {
    static int a, b = 0;

    static void far() {
        int r1 = b;
        a = 1;
    }

    static void bar() {
        int r2 = a;
        b = 1;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> far());
        Thread t2 = new Thread(() -> bar());

        t1.start();
        t2.start();

//        t1.join();
//        t2.join();

        System.out.printf("a = %d b = %d\n", a, b);
    }
}
