package concurrency.other;

import java.util.ArrayList;

public class WaitNotify {
    public static void main(String[] args) {
        Factorial factorial = new Factorial(5);
        factorial.run();
        System.out.println(factorial.result);


    }
}

class Factorial implements Runnable {
    public int n = 0;
    public long result = 1;

    public Factorial(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 2; i <= n; i++)
            result *= i;
    }
}

class JobQueue {
    ArrayList jobs = new ArrayList();

    public synchronized void put(Runnable job) {
        jobs.add(job);
        this.notifyAll();
    }

    public synchronized Runnable getJob() throws InterruptedException {
        while (jobs.size() == 0)
            this.wait();

        return (Runnable) jobs.remove(0);
    }
}