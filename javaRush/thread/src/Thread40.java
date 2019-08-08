/*
https://javarush.ru/groups/posts/2065-threadom-java-ne-isportishjh--chastjh-iv---callable-future-i-druzjhja
Thread'ом Java не испортишь: Часть IV — Callable, Future и друзья
 */

public class Thread40 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("Hello World");
        new Thread(task).start();
    }
}
