package concurrency.javarush.task2705;

/* 
Второй вариант deadlock
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        new Thread(solution::secondMethod).start();
        new Thread(solution::firstMethod).start();
    }
}