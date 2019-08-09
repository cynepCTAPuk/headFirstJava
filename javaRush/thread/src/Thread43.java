import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class Thread43 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completed = CompletableFuture.completedFuture("Просто значение");
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() ->
                System.out.println("run " + Thread.currentThread().getName()));
        CompletableFuture<String> supplier = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply " + Thread.currentThread().getName());
            return "Значение";
        });

        Thread.sleep(1_000);
        System.out.println(completed);
        System.out.println(completed.get());
        System.out.println(voidCompletableFuture);
        System.out.println(supplier);
        System.out.println(supplier.get());

        List<String> array = Arrays.asList("one", "two");
        Stream<String> stringStream = array.stream().map(value -> {
            System.out.println("Executed");
            return value.toUpperCase();
        });
    }
}
