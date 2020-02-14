package concurrency;

public class ClockIsInterrupted2 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread clock = new Thread(new Clock3());
        clock.start();
        Thread.sleep(10_000);
        clock.interrupt();
    }

}

class Clock4 implements Runnable {
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                Thread.sleep(1_000);
                System.out.println("Tik");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
