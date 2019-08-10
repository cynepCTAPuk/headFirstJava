/*
 https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 Thread'ом Java не испортишь: Часть VI — К барьеру!
 */

public class Thread60 {
    public static void main(String[] args) {
        Runnable task = () -> {
            Thread thread = Thread.currentThread();
            System.out.println("Hello from " + thread.getName());
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
