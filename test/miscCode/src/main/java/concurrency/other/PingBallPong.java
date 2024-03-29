package concurrency.other;

/**
 * 1) Попробуйте убрать synchronized
 * 2) Попробуйте добавить вывод из 3-го потока: "ball"
 */
public class PingBallPong {
    private String last = "-PONG";
    private String previous = "-Ball-";

    private synchronized void action(String message) {
        while (true) {
            if (last.equals(message) | previous.equals(message)) {
                wait(this);
            } else {
                System.out.println(message);
                previous = last;
                last = message;
                sleep(1_000);
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PingBallPong pingPong = new PingBallPong();
        new Thread(() -> pingPong.action("ping-")).start();
        new Thread(() -> pingPong.action("-Ball-")).start();
        new Thread(() -> pingPong.action("-PONG")).start();
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void wait(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
