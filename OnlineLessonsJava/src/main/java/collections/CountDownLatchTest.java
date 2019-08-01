package collections;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Job(countDownLatch);
        new Job(countDownLatch);
        new Job(countDownLatch);

        countDownLatch.await();
        System.out.println("All jobs done. Count: " + count);
    }
}

class Job extends Thread {
    CountDownLatch countDownLatch;

    public Job(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Job done. Count: " + ++CountDownLatchTest.count);
        countDownLatch.countDown();
    }
}
