volatile int count = 0;

private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

void safeIncrement() {
    // enter your code
    count++;
    // enter your code
}