package concurrency.other;

public class ClockIsInterrupted1 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Clock3 clock = new Clock3();
        clock.start();
        Thread.sleep(10_000);
        clock.interrupt();
    }

}

class Clock3 extends Thread {
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                System.out.println("Работа потока была прервана");
                break;
            }
            System.out.println("Tik");
        }
    }
}