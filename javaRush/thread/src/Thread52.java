/*
https://javarush.ru/groups/posts/2078-threadom-java-ne-isportishjh--chastjh-v---executor-threadpool-fork-join-pool
Thread'ом Java не испортишь: Часть V — Executor, ThreadPool, Fork Join
 */

import java.util.concurrent.*;

public class Thread52 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> Thread.currentThread().getName();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 6; i++) {
            Future result = service.submit(task);
            System.out.println(i + ": " + result.get());
        }
        service.shutdown();
    }
}
