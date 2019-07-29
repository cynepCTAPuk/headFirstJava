import java.util.concurrent.atomic.AtomicInteger;

// Атомарность
public class Thread34 {
    public static int value = 0;
    public static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++) {
                value++;
                atomic.incrementAndGet();
            }
        };
        for (int i = 0; i < 5; i++) new Thread(task).start();
        Thread.sleep(100);
        System.out.printf("%,d\n", value);
        System.out.printf("%,d", atomic.get());
    }
}
