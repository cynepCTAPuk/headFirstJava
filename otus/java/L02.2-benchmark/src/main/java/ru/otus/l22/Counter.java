package ru.otus.l22;

public class Counter {
    static int c;

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.cycle();
    }

    private void cycle() {
        while (true) {
            print();
            c++;
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void print() {
//        System.out.println("\"args\" = " + "args");
        System.out.println("giga counter = " + c);
    }
}
