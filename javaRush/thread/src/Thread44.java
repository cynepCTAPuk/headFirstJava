import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

public class Thread44 {

    public static void main(String[] args) {
        AtomicLong longValue = new AtomicLong(0);
        Runnable task = () -> longValue.set(new Date().getTime());
        Function<Long, Date> dateConverter = (longvalue) -> new Date(longvalue);
        Consumer<Date> printer = date -> {
            System.out.println(date);
            System.out.flush();
        };
        CompletableFuture.runAsync(task)
                .thenApply(v -> longValue.get())
                .thenApply(dateConverter)
                .thenAccept(printer);

        CompletableFuture.runAsync(() -> longValue.set(0))
                .thenApply(v -> longValue.get())
                .thenApply(dateConverter)
                .thenAccept(printer);
    }
}
