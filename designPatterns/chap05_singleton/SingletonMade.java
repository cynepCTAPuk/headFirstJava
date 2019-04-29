package chap05_singleton;

public class SingletonMade {
    private static SingletonMade uniqueInstance = new SingletonMade();

    // other useful instance variables here
    private SingletonMade() {
    }

    public static synchronized SingletonMade getInstance() {
        return uniqueInstance;
    }
// Другие методы
}
