package chap28_Concurrency;
// Extend Phaser and override onAdvance() so that only a specific number of phases are executed

import java.util.concurrent.Phaser;

// Extend MyPhaser to allow only a specific number of phases to be executed
class MyPhaser extends Phaser {
    private int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    // Override onAdvance() to execute the specified number of phases
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        // This println() statement is for illustration only.
        // Normally, onAdvance() will not display output.
        System.out.println("Phase " + phase + " completed\n");
        // if all phases have completed, return true
        return phase == numPhases || registeredParties == 0;
    }
}

class MyThread3 implements Runnable {
    private Phaser phaser;
    private String name;

    MyThread3(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Thread " + name + " Beginning Phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            // Pause a bit to prevent umbled output.This is for illustration only.
            // It is not required for the proper operation of the phase
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4);
        System.out.println("Starting\n");
        new Thread(new MyThread3(myPhaser, "A")).start();
        new Thread(new MyThread3(myPhaser, "B")).start();
        new Thread(new MyThread3(myPhaser, "C")).start();
        // Wait for the specified number of phases to complete
        while (!myPhaser.isTerminated()) myPhaser.arriveAndAwaitAdvance();
        System.out.println("The Phase is terminated");
    }

}
