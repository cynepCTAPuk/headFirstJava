package chap15;


class MyRunnable1 implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doMore();
    }

    private void doMore() {
        System.out.println("top of the stack");
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MyRunnable1 threadJob = new MyRunnable1();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("back in main");
    }
}
