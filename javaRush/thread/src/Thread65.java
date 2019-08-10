/*
 https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 Thread'ом Java не испортишь: Часть VI — К барьеру!
 */

import java.util.concurrent.Exchanger;

public class Thread65 {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Runnable task = () -> {
            try {
                Thread thread = Thread.currentThread();
                String withThreadName = exchanger.exchange(thread.getName());
                System.out.println(thread.getName() + " обменялся с " + withThreadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
