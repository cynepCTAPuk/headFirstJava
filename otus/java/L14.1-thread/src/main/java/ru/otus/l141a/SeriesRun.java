package ru.otus.l141a;

/**
 * Example of threads' organization.
 * All threads try to print self id. But we need them to print it in serial order.
 */
class SeriesRun {
    private static final int MAX_THREADS_COUNT = 50;
    private int currentMax = 1;
    private static int idx = 0;

    void start() throws InterruptedException {
        for (int i = currentMax; i <= MAX_THREADS_COUNT; ++i) {
            int threadId = i; // effectively final
            new Thread(() -> {
                try {
                    synchronized (SeriesRun.this) {
                        while (threadId > currentMax) {
                            System.out.println("---Waiting id: " + threadId + " idx: " + ++idx);
                            SeriesRun.this.wait();
                        }
                        System.out.println("Thread id: " + threadId + " idx: " + ++idx);
                        currentMax++;
                        SeriesRun.this.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
