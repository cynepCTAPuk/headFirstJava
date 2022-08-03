package concurrency.other;

public class SimpleThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new SimpleThread().start();
        new Thread(new SimpleRunnable()).start();
    }
}
