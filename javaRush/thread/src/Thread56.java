/*
https://javarush.ru/groups/posts/2078-threadom-java-ne-isportishjh--chastjh-v---executor-threadpool-fork-join-pool
Thread'ом Java не испортишь: Часть V — Executor, ThreadPool, Fork Join
 */

import java.util.concurrent.*;

public class Thread56 {
    public static void main(String[] args) {
        Object lock = new Object();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newWorkStealingPool();
        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            lock.wait(1_000);
            System.out.println("Finished");
            return "result";
        };

        for (int i = 0; i < 5; i++) executorService.submit(task);

        executorService.shutdown();
    }
}
