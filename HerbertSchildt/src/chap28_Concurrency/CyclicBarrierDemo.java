package chap28_Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// An example of CyclicBarrierDemo
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarrierAction());
        System.out.println("Starting");
        new Thread(new MyThread1(cyclicBarrier,"A")).start();
        new Thread(new MyThread1(cyclicBarrier,"B")).start();
        new Thread(new MyThread1(cyclicBarrier,"C")).start();
        new Thread(new MyThread1(cyclicBarrier,"X")).start();
        new Thread(new MyThread1(cyclicBarrier,"Y")).start();
        new Thread(new MyThread1(cyclicBarrier,"Z")).start();
    }
}

// A thread of execution that uses a CyclicBarrier
class MyThread1 implements Runnable {
    CyclicBarrier cyclicBarrier;
    String name;

    public MyThread1(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cyclicBarrier.await();
//            System.out.println(name);
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class BarrierAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Barrier Reached!");
    }
}