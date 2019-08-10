/*
https://javarush.ru/groups/posts/2078-threadom-java-ne-isportishjh--chastjh-v---executor-threadpool-fork-join-pool
Thread'ом Java не испортишь: Часть V — Executor, ThreadPool, Fork Join
 */

import java.util.concurrent.*;

public class Thread54 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(4);
        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        };
        scheduledExecutorService.schedule(task, 1, TimeUnit.MINUTES);
        scheduledExecutorService.shutdown();
    }
}
