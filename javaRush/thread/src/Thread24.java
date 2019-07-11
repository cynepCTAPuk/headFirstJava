import java.util.concurrent.TimeUnit;

public class Thread24 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            long t1 = System.currentTimeMillis();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                System.out.printf("Interrupted: %,d ms", (System.currentTimeMillis() - t1));
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        System.out.println("Finished");
    }
}