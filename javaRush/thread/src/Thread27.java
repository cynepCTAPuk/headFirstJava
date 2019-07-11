public class Thread27 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        // task будет ждать, пока его не оповестят через lock
        Runnable task = () -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
            // После оповещения нас мы будем ждать, пока сможем взять лок
            System.out.println("thread " + Thread.currentThread().getName());
        };
        Thread taskThread1 = new Thread(task);
        Thread taskThread2 = new Thread(task);
        taskThread1.start();
        taskThread2.start();
        // Ждём и после этого забираем себе лок, оповещаем и отдаём лок
        Thread.currentThread().sleep(3_000);
        System.out.println("thread2 " + Thread.currentThread().getName());
        synchronized (lock) {
            lock.notifyAll();
            System.out.println("notify " + Thread.currentThread().getName());
        }
    }
}