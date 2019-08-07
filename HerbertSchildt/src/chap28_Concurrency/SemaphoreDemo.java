package chap28_Concurrency;
// A simple semaphore example

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new IncThread(semaphore, "A")).start();
        new Thread(new DecThread(semaphore, "B")).start();
    }
}

// A shared resource
class Shared {
    static int count = 0;
}

// A thread of execution that increment count
class IncThread implements Runnable {
    Semaphore semaphore;
    String name;

    public IncThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            // First, get a permit
            System.out.println(name + " is waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " gets a permit");
            // Now, access shared resource
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                // Now, allow a context swithc -- if possible
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        // Release the permit
        System.out.println(name + " release the permit");
        semaphore.release();
    }
}

// A thread of execution that decrement count
class DecThread implements Runnable {
    Semaphore semaphore;
    String name;

    public DecThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            // First, get a permit
            System.out.println(name + " is waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " gets a permit");
            // Now, access shared resource
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                // Now, allow a context swithc -- if possible
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        // Release the permit
        System.out.println(name + " release the permit");
        semaphore.release();
    }
}

