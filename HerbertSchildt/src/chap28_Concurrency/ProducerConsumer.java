package chap28_Concurrency;

import java.util.concurrent.Semaphore;

// An implementation of a producer and consumer that use semaphore to control synchronization
class Q {
    private int n;
    // Start with consumer semaphore unavailable
    private static Semaphore semaphoreConsumer = new Semaphore(0);
    private static Semaphore semaphoreProducer = new Semaphore(1);

    void get() {
        try {
            semaphoreConsumer.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Got: " + n);
        semaphoreProducer.release();
    }

    void put(int n) {
        try {
            semaphoreProducer.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        this.n = n;
        System.out.println("Put: " + n);
        semaphoreConsumer.release();
    }
}

class Producer implements Runnable {
    private Q q;

    Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) q.put(i);
    }
}

class Consumer implements Runnable {
    private Q q;

    Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) q.get();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Q q = new Q();
        new Thread(new Consumer(q), "Consumer").start();
        new Thread(new Producer(q), "Producer").start();
    }
}
