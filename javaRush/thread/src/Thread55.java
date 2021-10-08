/*
https://javarush.ru/groups/posts/2078-threadom-java-ne-isportishjh--chastjh-v---executor-threadpool-fork-join-pool
Thread'ом Java не испортишь: Часть V — Executor, ThreadPool, Fork Join
 */

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Thread55 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(4);
        Runnable task = () -> System.out.println(Thread.currentThread().getName());
//        scheduledExecutorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(task, 1, 2, TimeUnit.SECONDS);
    }
}
