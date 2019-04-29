package chap05_singleton;

public class SingletonSync {
    private static SingletonSync uniqueInstance;

    // other useful instance variables here
    private SingletonSync() {
    }

    public static synchronized SingletonSync getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonSync();
        }
        return uniqueInstance;
    }
// Другие методы
}
