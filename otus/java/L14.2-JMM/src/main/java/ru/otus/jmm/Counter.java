package ru.otus.jmm;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    static final int N = 2;
    static final int J = 1_000_000_000;
    static AtomicLong value = new AtomicLong(0);

    void inc() {
        value.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        Counter c = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < J; i++) c.inc();
        };
        Thread[] ts = new Thread[N];
        for (int i = 0; i < N; i++) {
            ts[i] = new Thread(runnable);
            ts[i].start();
        }
        for (int i = 0; i < N; i++) ts[i].join();

        long t2 = System.currentTimeMillis();
        double d = ((N * J - c.value.longValue()) * 100.00) / (N * J);
        System.out.printf("Time: %,d\n", t2-t1);
        System.out.printf("Count: %,d\n", c.value.longValue());
        System.out.printf("Процент потери данных: %.2f%s\n", d, "%");
    }
}
