//: chap21_concurrency/Chopstick.java
// Chopsticks for dining philosophers.
package chap21_concurrency;
public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while(taken) wait();
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
} ///:~