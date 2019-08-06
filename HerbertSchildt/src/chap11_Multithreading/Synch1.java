package chap11_Multithreading;

// This program uses a synchronized block
class Callme1 {
    void call(String msg) { // method can be "synchronized"
        System.out.print("[" + msg);
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller1 implements Runnable {
    String msg;
    Callme1 target;
    Thread t;

    public Caller1(Callme1 target, String msg) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (target) { // synchronized block
            target.call(msg);
        }
    }
}

public class Synch1 {
    public static void main(String[] args) {
        Callme1 target = new Callme1();
        Caller1 ob1 = new Caller1(target, "Hello");
        Caller1 ob2 = new Caller1(target, "Synchronized");
        Caller1 ob3 = new Caller1(target, "World");
        // Start the threads
        ob1.t.start();
        ob2.t.start();
        ob3.t.start();
        // wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
