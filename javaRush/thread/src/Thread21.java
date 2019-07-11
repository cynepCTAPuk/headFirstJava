/*
https://javarush.ru/groups/posts/2048-threadom-java-ne-isportishjh--chastjh-ii---sinkhronizacija
 */
public class Thread21 {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                long t1 = System.currentTimeMillis();
                Thread.sleep(1_000 * 60);
                System.out.printf("Waked up: %,d ms", (System.currentTimeMillis() - t1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
