package ru.otus.jmm;

public class FactoryTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Factory.instance);
        System.out.println(Factory.get(0, "zero"));

        Runnable runnable1 = () -> System.out.println(Factory.get(1, "one"));
        Runnable runnable2 = () -> System.out.println(Factory.get(2, "two"));

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        Thread.sleep(100);
        System.out.println(Factory.instance.i + ":" + Factory.instance.s);
    }
}
