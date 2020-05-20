ReentrantLock lockA = new ReentrantLock();
ReentrantLock lockB = new ReentrantLock();

AtomicInteger count = new AtomicInteger(2);

void method1() {
    job1();
}

void method2() {
    job2();
}