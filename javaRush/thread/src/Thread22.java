import java.util.concurrent.TimeUnit;

public class Thread22 {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                long t1 = System.currentTimeMillis();
                TimeUnit.SECONDS.sleep(60);
                System.out.printf("Waked up: %,d ms", (System.currentTimeMillis() - t1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
//        thread.interrupt();
    }
}
