package shortPuzzles;

public class TreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestThread());
        System.out.println("Hello, it's a main thread");
        thread.start();
        thread.join();
        System.out.println("Good bye");
    }

    static class TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello, it's simple thread");
        }

        public void join() {
            System.out.println("Hello it's method join()");
        }
    }
}

