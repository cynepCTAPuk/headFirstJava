import java.util.concurrent.Semaphore;

public class Thread28 {
    public static void main(String[] args) {
        // permits - счётчик потоков, задаётся максимальное число потоков
        // при заходе потока -> permit--, при выходе -> permit++
        // достигнув 0 ждём когда какой-либо поток не выйдет

        Semaphore semaphore = new Semaphore(0);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            // Просим разрешение и ждём, пока не получим его
            e.printStackTrace();
        }
        System.out.println("Hello, World!");
    }
}