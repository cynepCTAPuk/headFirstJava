public class Thread23 {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) ;
            System.out.printf("Finished: %,d ms", (System.currentTimeMillis() - t1));
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }
}
