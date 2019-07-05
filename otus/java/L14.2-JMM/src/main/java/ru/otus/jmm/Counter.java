package ru.otus.jmm;

public class Counter {
    static final int N = 100_000;
    static final int J = 10;
    long val = 0;

    void inc() {
        val++;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < J; i++) c.inc();
        };
        Thread[] ts = new Thread[N];
        for (int i = 0; i < N; i++) {
            ts[i] = new Thread(r);
            ts[i].start();
        }
        for (int i = 0; i < N; i++) ts[i].join();
        System.out.printf("Count: %,d\n", c.val);
    }
}
