package chap28_Concurrency;
// A simple lock example

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new LockThread(lock, "A")).start();
        new Thread(new LockThread(lock, "B")).start();
    }
}

// A shared resource
class Shared1 {
    static int count = 0;
}

// A thread of execution that increment count
class LockThread implements Runnable {
    private ReentrantLock lock;
    private String name;

    LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            // First, lock count
            System.out.println(name + " is waiting to lock count");
            lock.lock();
            System.out.println(name + " is locking count");

            Shared1.count++;
            System.out.println(name + ": " + Shared1.count);

            // Now, allow a context switch -- if possible
            System.out.println(name + " is sleeping");
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            // Unlock
            System.out.println(name + " is unlocking count");
            lock.unlock();
        }
    }
}