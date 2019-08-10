import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread51 {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        Runnable task = () -> System.out.println(i.getAndIncrement() + ": " + "Task executed");
        Executor executor = (runnable) -> new Thread(runnable).start();
        executor.execute(task);
        executor.execute(task);
    }
}
