import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Thread45 {
    public static class NewsService {
        static String getMessage() {
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Message";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Supplier newsSupplier = NewsService::getMessage;

        CompletableFuture<String> reader = CompletableFuture.supplyAsync(newsSupplier);
        CompletableFuture.completedFuture("!!")
                .thenCombine(reader, (a, b) -> b + a)
                .thenAccept(System.out::println)
                .get();

        CompletableFuture.completedFuture(2L)
                .thenCompose(val -> CompletableFuture.completedFuture(val + 2))
                .thenAccept(System.out::println);

        CompletableFuture.completedFuture(2L)
                .thenApply(a -> {
                    throw new IllegalStateException("error");
                })
                .thenApply(a -> 3L)
                .exceptionally(ex -> 0L)
                .thenAccept(System.out::println);

    }
}
