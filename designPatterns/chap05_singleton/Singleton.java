package chap05_singleton;

public class Singleton {
    private static Singleton uniqueInstance;

    // other useful instance variables here
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
// Другие методы
}