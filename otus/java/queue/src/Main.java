import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    final static int SEED = 42;
    final static int SIZE = 1_000;

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(0);
        Random random = new Random(SEED);

        int sum1 = 0;
        for (int i = 0; i < SIZE; i++) {
            int element = random.nextInt();
            queue.add(element);
            sum1 += element;
        }
        System.out.printf("sum1 = %,d%n", sum1);

        int sum2 = 0;
        for (int i = 0; i < SIZE; i++) {
            Integer element = queue.poll();
            if (element == null) break;
            sum2 += element;
        }
        System.out.printf("sum2 = %,d%n", sum2);
        System.out.flush();

        List<Future<Integer>> results = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Random random2 = new Random(SEED);
        for (int i = 0; i < SIZE; i++) {
            executorService.submit(() -> {
                int element = random2.nextInt();
                queue.add(element);
            });
            Future<Integer> future = executorService.submit(() -> queue.poll());
            results.add(future);
        }
        int sum3 = 0;
        for (Future<Integer> result : results) {
            try {
                sum3 += result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("sum3 = %,d%n", sum3);
    }
}
