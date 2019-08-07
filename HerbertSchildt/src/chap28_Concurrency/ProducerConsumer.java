package chap28_Concurrency;

import java.util.concurrent.Semaphore;

// An implementation of a producer and consumer that use semaphore to control synchronization
class Q {
    int n;
    // Start with consumer semaphore unavailable
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semPro = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Got: " + n);
        semPro.release();
    }

    void put(int n) {
        try {
            semPro.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        this.n = n;
        System.out.println("Put: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) q.put(i);
    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
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
