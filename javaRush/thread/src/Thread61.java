/*
 https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 Thread'ом Java не испортишь: Часть VI — К барьеру!
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread61 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Runnable task = () -> {
            lock.lock();
            Thread thread = Thread.currentThread();
            System.out.println("Hello from " + thread.getName());
            lock.unlock();
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
