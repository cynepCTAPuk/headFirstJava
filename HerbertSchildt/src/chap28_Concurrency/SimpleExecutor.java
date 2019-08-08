package chap28_Concurrency;
// A simple example that uses an Executor

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutor {
    public static void main(String[] args) {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Starting");
        // Start the threads
        es.execute(new MyThread4(cdl1, "A"));
        es.execute(new MyThread4(cdl2, "B"));
        es.execute(new MyThread4(cdl3, "C"));
        es.execute(new MyThread4(cdl4, "D"));

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        es.shutdown();
        System.out.println("Done");
    }
}

class MyThread4 implements Runnable {
    CountDownLatch latch;
    String name;

    public MyThread4(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
