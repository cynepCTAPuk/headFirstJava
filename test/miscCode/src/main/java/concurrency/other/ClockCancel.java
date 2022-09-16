package concurrency.other;

public class ClockCancel {
    public static void main(String[] args) throws InterruptedException {
        Clock1 clock = new Clock1();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10_000);
        clock.cancel();
    }
}

class Clock1 implements Runnable {
    private volatile boolean isCancel = false;

    public void cancel() {
        this.isCancel = true;
    }

    public void run() {
        while (!isCancel) {
            try {
                Thread.sleep(1_000);
                System.out.println("Tik");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}