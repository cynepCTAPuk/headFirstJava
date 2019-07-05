package ru.otus.l141b;

/**
 * Example of unsafe code.
 * <p>
 * 1. static
 * 2. volatile
 * 3. synchronized
 * 4. synchronized(object)
 * 5. synchronized(class)
 */

public final class CountedThread extends BaseThread {
//    private  static int i;
//    private static final Object lock = new Object();
    private static final StateObject i = new StateObject();

    protected void doSomething() {
//        synchronized (CountedThread.class) {
//        synchronized (lock) {
            super.doSomething();
//            i++;
//        }
        i.increment();
    }

    int getI() {
//        return i;
        return i.getI();
    }
}
