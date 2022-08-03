package concurrency.other;

public class PingPong1 {
    static class Ping implements Runnable {
        @Override
        public void run() {
            System.out.print(" Ping-");
        }
    }

    static class Pong implements Runnable {
        @Override
        public void run() {
            System.out.print("-Pong ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread ping = new Thread(new Ping());
            ping.start();
            Thread pong = new Thread(new Pong());
            pong.start();
            pong.join();
        }
    }
}
