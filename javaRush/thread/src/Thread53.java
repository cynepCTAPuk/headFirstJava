/*
https://javarush.ru/groups/posts/2078-threadom-java-ne-isportishjh--chastjh-v---executor-threadpool-fork-join-pool
Thread'ом Java не испортишь: Часть V — Executor, ThreadPool, Fork Join
 */

import java.util.concurrent.*;

public class Thread53 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threadBound = 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,
                threadBound, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        Callable<String> task = () -> {
            Thread.sleep(1_000);
            return Thread.currentThread().getName();
        };

        for (int i = 0; i < threadBound + 1; i++)
            threadPoolExecutor.submit(task);

        threadPoolExecutor.shutdown();
    }
}
