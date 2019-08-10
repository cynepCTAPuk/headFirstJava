/*
 https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 Thread'ом Java не испортишь: Часть VI — К барьеру!
 */

import java.util.concurrent.Semaphore;

public class Thread62 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);

        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("Finished " + Thread.currentThread().getName());
//                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
            Thread.sleep(1_000);
            semaphore.release(1);
        }
    }
}
