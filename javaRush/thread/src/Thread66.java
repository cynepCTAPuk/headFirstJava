/*
 https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 Thread'ом Java не испортишь: Часть VI — К барьеру!
 */

import java.util.concurrent.SynchronousQueue;

public class Thread66 {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        Runnable task = () -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        queue.put("One");
        queue.put("Two");
    }
}
