package ru.otus.l141a;

class RandomRun {

    private static final int MAX_THREADS_COUNT = 20;

    void start() {
        long startTimeNS = System.nanoTime();
        for (int i = 0; i < MAX_THREADS_COUNT; ++i) {
//            new Thread(() -> System.out.println(Thread.currentThread().getName() + "\t: " + (System.nanoTime() - startTimeNS) + "ns")).start();
            new Thread(() -> System.out.printf("%-9s : %,11d\n",
                    Thread.currentThread().getName(),(System.nanoTime() - startTimeNS))).start();
        }
    }
}
