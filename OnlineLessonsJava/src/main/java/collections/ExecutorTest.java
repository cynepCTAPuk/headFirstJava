package collections;

import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunnable());
        executorService.submit(new MyCallable());
        executorService.shutdown();

        System.out.println(TimeUnit.HOURS.toMinutes(24));
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.print("|");
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() {
            System.out.print("-");
            return "-";
        }
    }
}
