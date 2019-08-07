package chap28_Concurrency;
// An example of CountDownLatch

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("Starting");
        new Thread(new MyThread(countDownLatch)).start();
        System.out.println("countDownLatch.getCount(): " + countDownLatch);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Done");
    }
}

class MyThread implements Runnable {
    CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            countDownLatch.countDown(); // decrement count
            System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
        }
    }
}