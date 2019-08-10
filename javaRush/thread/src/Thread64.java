/*
 https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 Thread'ом Java не испортишь: Часть VI — К барьеру!
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread64 {
    public static void main(String[] args) {
        Runnable action = () -> System.out.println("На старт!");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, action);

        Runnable task = () -> {
            try {
                cyclicBarrier.await();
                System.out.println("Finished");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        };

        System.out.println("Limit: " + cyclicBarrier.getParties());
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
    }
}
