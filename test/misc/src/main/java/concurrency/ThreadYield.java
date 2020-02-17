package concurrency;

public class ThreadYield {
    public static void main(String[] args) {
        Runnable r = () -> {
            int counter = 3;
            while (counter > 0) {
                System.out.println(Thread.currentThread().getName());
                counter--;
                Thread.yield();
            }
        };
        new Thread(r).start();
        new Thread(r).start();
    }
}