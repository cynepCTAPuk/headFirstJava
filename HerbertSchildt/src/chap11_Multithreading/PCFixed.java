package chap11_Multithreading;

// A correct implementation of a producer and consumer
class Q_1 {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer_1 implements Runnable {
    Q_1 q;
    Thread t;

    public Producer_1(Q_1 q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) q.put(i++);
    }
}

class Consumer_1 implements Runnable {
    Q_1 q;
    Thread t;

    public Consumer_1(Q_1 q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true) q.get();
    }

}

public class PCFixed {
    public static void main(String[] args) {
        Q_1 q = new Q_1();
        Producer_1 p = new Producer_1(q);
        Consumer_1 c = new Consumer_1(q);
        // Start the threads
        p.t.start();
        c.t.start();
        System.out.println("Press Control-C to stop");
    }
}
