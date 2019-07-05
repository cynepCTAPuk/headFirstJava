package ru.otus.l141b;

/**
 * @author v.chibrikov
 */
class InterferenceExample {

    void start() throws InterruptedException {

        CountedThread thread1 = new CountedThread();
        CountedThread thread2 = new CountedThread();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.printf("Expected: %,d\n", CounterSemaphore.HUNDRED_MILLION);
        System.out.printf("Result 1: %,d\n", thread1.getI());
        System.out.printf("Result 2: %,d\n", thread2.getI());
    }
}
