package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CopyOnWriteArrayListTest {
    private static List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private static List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
    private static final int SIZE = 10_000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        fillList(synchronizedList);
        fillList(copyOnWriteArrayList);

        System.out.println("List synchronized: ");
        checkList(synchronizedList);

        System.out.println("CopyOnWriteArrayList: ");
        checkList(copyOnWriteArrayList);
    }

    private static void checkList(List<Integer> list) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Long> f1 = executorService.submit(new ListRunner(0, SIZE / 2, list, latch));
        Future<Long> f2 = executorService.submit(new ListRunner(SIZE / 2, SIZE, list, latch));
        latch.countDown();
        System.out.printf("Thread 1: %,8d\n", f1.get() / 1_000);
        System.out.printf("Thread 2: %,8d\n", f2.get() / 1_000);
        executorService.shutdown();
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < SIZE; i++) list.add(i);
    }

    static class ListRunner implements Callable<Long> {
        int start;
        int end;
        List<Integer> list;
        CountDownLatch latch;

        ListRunner(int start, int end, List<Integer> list, CountDownLatch latch) {
            this.start = start;
            this.end = end;
            this.list = list;
            this.latch = latch;
        }

        @Override
        public Long call() throws InterruptedException {
            latch.await();
            long startTime = System.nanoTime();
            for (int i = start; i < end; i++) {
                list.get(i);
//                if (i % 100_000 == 0) list.add(i);
            }
            return System.nanoTime() - startTime;
        }
    }
}
