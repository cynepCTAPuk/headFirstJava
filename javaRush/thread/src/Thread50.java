/*
 https://javarush.ru/groups/posts/2078-threadom-java-ne-isportishjh--chastjh-v---executor-threadpool-fork-join-pool
 Thread'ом Java не испортишь: Часть V — Executor, ThreadPool, Fork Join
*/
public class Thread50 {

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task executed");
        Thread thread = new Thread(task);
        thread.start();
    }
}
