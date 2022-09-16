package concurrency.threadpooltest;

public class Counter {
    public Double count(double a) {
        for (int i = 0; i < 1_000_000; i++) a = a + Math.tan(a);
        return a;
    }
}