package ru.otus.l141a;

/**
 * Example of threads' organization.
 * All threads try to print self id. But we need them to print it in serial order.
 */
class SeriesRun2 {
    private static final int MAX_THREADS_COUNT = 20;
    private int currentMax = 1;
    private static int count = 0;

    void start() throws InterruptedException {
        for (int i = currentMax; i <= MAX_THREADS_COUNT; ++i) {
            int threadId = i; // effectively final
            new Thread(() -> {
                try {
                    filter(threadId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private synchronized void filter(int threadId) throws InterruptedException {
        while (threadId > currentMax) {
            System.err.println("Waiting id: " + threadId + " count: " + ++count);
            SeriesRun2.this.wait();
        }
        System.out.println("Thread id: " + threadId + " count: " + ++count);
        currentMax++;
        SeriesRun2.this.notifyAll();
    }
}
