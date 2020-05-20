volatile int count = 0;

ReentrantLock lock = new ReentrantLock();

void safeIncrement() {
    // enter your code
    count++;
    // enter your code
}