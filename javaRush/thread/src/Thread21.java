/*
https://javarush.ru/groups/posts/2048-threadom-java-ne-isportishjh--chastjh-ii---sinkhronizacija
 */
public class Thread21 {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        Runnable task = () -> {
            try {
                int secondsToWait = 1_000 * 60;
                Thread.currentThread().sleep(secondsToWait);
                System.out.printf("Waked up: %,d ms", (System.currentTimeMillis() - t1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
