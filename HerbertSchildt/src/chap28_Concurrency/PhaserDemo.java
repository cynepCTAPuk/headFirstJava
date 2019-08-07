package chap28_Concurrency;

// An example of Phaser

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currentPhase;
        System.out.println("Starting");
        new Thread(new MyThread2(phaser, "A")).start();
        new Thread(new MyThread2(phaser, "B")).start();
        new Thread(new MyThread2(phaser, "C")).start();

        // Wait for all threads to complete phase one
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete");

        // Wait for all threads to complete phase two
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete");

        // Deregister the main thread
        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) System.out.println("The Phaser is terminated");
    }
}

// A thread of execution that uses a Phaser
class MyThread2 implements Runnable {
    Phaser phaser;
    String name;

    public MyThread2(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " Beginning Phase One");
        phaser.arriveAndAwaitAdvance(); // Signal arrival
        // Pause a bit to prevent jumbled output. This is for illustration only.
        // It is not required for the proper operation of the phaser.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Two");
        phaser.arriveAndAwaitAdvance(); // Signal arrival
        // Pause a bit to prevent jumbled output. This is for illustration only.
        // It is not required for the proper operation of the phaser.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phaser.arriveAndDeregister(); // Signal arrival and deregister
    }
}