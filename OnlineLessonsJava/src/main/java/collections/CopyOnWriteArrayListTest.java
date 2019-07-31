package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CopyOnWriteArrayListTest {
    static List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    static List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int size = 100_000;
        fillList(synchronizedList, size);
        fillList(copyOnWriteArrayList, size);

        System.out.println("List synchronized: ");
        checkListByGet(synchronizedList, size);

        System.out.println("CopyOnWriteArrayList: ");
        checkListByGet(copyOnWriteArrayList, size);
    }

    private static void checkListByGet(List<Integer> list, int size)
            throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(new ListRunner(0, size / 2, list, latch));
        Future<Long> f2 = ex.submit(new ListRunner(size / 2, size, list, latch));
        latch.countDown();
        System.out.printf("Thread 1: %,8d\n", f1.get() / 1_000);
        System.out.printf("Thread 1: %,8d\n", f2.get() / 1_000);
        ex.shutdown();
    }

    private static void fillList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) list.add(i);
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
            for (int i = start; i < end; i++) list.get(i);
            return System.nanoTime() - startTime;
        }
    }
}
