package chap11_Multithreading;

// Create a multiple thread
class NewThread implements Runnable {
    String name; // name of thread
    Thread t;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
    }

    // This is the entry point for the second thread
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1_000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");
        // Start the threads
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();
        try {
            // wait for other threads to end
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
