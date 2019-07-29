import java.util.concurrent.Executor;

public class Thread51 {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("Task executed");
        Executor executor = (runnable) -> new Thread(runnable).start();
        executor.execute(task);
    }
}
