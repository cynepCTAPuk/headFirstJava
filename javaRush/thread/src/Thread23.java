public class Thread23 {
    public static void main(String[] args) {
        Runnable task = () -> {
            long t1 = System.currentTimeMillis();
            while (!Thread.currentThread().isInterrupted()) {
                // Do some work
            }
            System.out.printf("Finished: %,d ms", (System.currentTimeMillis() - t1));
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }
}
