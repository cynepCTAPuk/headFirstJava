package concurrency;

public class ClockManager {
    public static boolean isClockRun = true;

    public static void main(String[] args) throws InterruptedException {
        Clock1 clock = new Clock1();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10000);
        isClockRun = false;
    }

}

class Clock implements Runnable {
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.print("\rTik");
                Thread.sleep(500);
                System.out.print("\rTak");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!ClockManager.isClockRun)
                return;
        }
    }
}


