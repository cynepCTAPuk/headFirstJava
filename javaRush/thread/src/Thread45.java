import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Thread45 {
    public static class NewsService {
        static String getMessage() {
            try {
                System.out.println("Ждём 2 секунды");
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Message";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Supplier newsSupplier = NewsService::getMessage;
        System.out.println(newsSupplier.get());

        CompletableFuture<String> reader = CompletableFuture.supplyAsync(newsSupplier);

        CompletableFuture
                .completedFuture("!!")
                .thenCombine(reader, (a, b) -> b + a + b)
                .thenAccept(System.out::println)
                .get();

        CompletableFuture
                .completedFuture(2L)
                .thenCompose(val -> CompletableFuture.completedFuture(val + 2))
                .thenAccept(System.out::println);

        CompletableFuture
                .completedFuture(2L)
                .thenApply(a -> {
                    throw new IllegalStateException("error");
                })
                .thenApply(a -> 3L)
                .exceptionally(ex -> 0L)
                .thenAccept(System.out::println);
    }
}
