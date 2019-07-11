import java.util.concurrent.locks.LockSupport;

public class Thread29 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            //Запаркуем текущий поток
            System.err.println("Will be Parked "
                    + " thread: " + Thread.currentThread().getName());
            LockSupport.park();
            // Как только нас распаркуют - начнём действовать
            System.err.println("Unparked "
                    + " thread: " + Thread.currentThread().getName());
        };
        Thread thread = new Thread(task);
        thread.start();
        Thread.currentThread().sleep(4_000);
        System.err.println("Thread state: " + thread.getState()
                + " thread: " + Thread.currentThread().getName());

        LockSupport.unpark(thread);
        Thread.currentThread().sleep(4_000);
    }
}