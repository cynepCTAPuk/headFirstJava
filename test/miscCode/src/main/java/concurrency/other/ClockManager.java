package concurrency.other;

public class ClockManager {
    public static boolean isClockRun = true;

    public static void main(String[] args) throws InterruptedException {
        Clock2 clock = new Clock2();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10_000);
        isClockRun = false;
    }

}

class Clock2 implements Runnable {
    public void run() {
        while (true) {
            try {
                Thread.sleep(250);
                System.out.print("\r| Tik ┐ $"); // 191
                Thread.sleep(250);
                System.out.print("\r/ Tak ┘ "); // 217
                Thread.sleep(250);
                System.out.print("\r- Tik └ "); // 192
                Thread.sleep(250);
                System.out.print("\r\\ Tak ┌ "); // 218
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!ClockManager.isClockRun) return;
        }
    }
}


