package chap28_Concurrency;
// A simple example of Atomic

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("B")).start();
        new Thread(new AtomThread("C")).start();
    }
}

class Shared2 {
    static AtomicInteger ai = new AtomicInteger(0);
}

// A thread of execution that increment count
class AtomThread implements Runnable {
    private String name;

    AtomThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        for (int i = 1; i <= 3; i++)
            System.out.println(name + " got: " + Shared2.ai.incrementAndGet());
    }
}