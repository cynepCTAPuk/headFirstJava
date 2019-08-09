import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread41 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable task = () -> "Hello World!";
        FutureTask<String> future = new FutureTask<String>(task);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
