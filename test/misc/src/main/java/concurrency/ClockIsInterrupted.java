package concurrency;

public class ClockIsInterrupted extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Clock3 clock = new Clock3();
        clock.start();
        Thread.sleep(10000);
        clock.interrupt();
    }

}

class Clock3 extends Thread {
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Работа потока была прервана");
                break;
            }
            System.out.println("Tik");
        }
    }
}