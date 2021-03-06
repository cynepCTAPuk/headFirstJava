package chap11_Multithreading;

// Create a second thread
class NewThread1 implements Runnable {
    Thread t;

    NewThread1() {
        // Create a new, second thread
        t = new Thread(this, "Demo Thread");
        System.out.println("Chile thread: " + t);
    }

    // This is the entry point for the second thread
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted");
        }
        System.out.println("Exiting child thread");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        NewThread1 nt = new NewThread1(); // create a new thread
        nt.t.start(); // Start the thread
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1_000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
