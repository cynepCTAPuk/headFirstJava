import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    final static int SEED = 42;
    final static int SIZE = 1_000;

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        Random random = new Random(SEED);
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < SIZE; i++) {
            int element = random.nextInt();
            queue.add(element);
            sum1 += element;
        }
        System.out.printf("sum1 = %,d%n", sum1);

        while (true) {
            Integer element = queue.poll();
            if (element == null) break;
            sum2 += element;
        }
        System.out.printf("sum2 = %,d%n", sum2);
        System.out.flush();

/*
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
*/
    }
}
