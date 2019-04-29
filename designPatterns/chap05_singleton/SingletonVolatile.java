package chap05_singleton;

public class SingletonVolatile {
    private volatile static SingletonVolatile uniqueInstance;

    // other useful instance variables here
    private SingletonVolatile() {
    }

    public static SingletonVolatile getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonVolatile.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonVolatile();
                }
            }
        }
        return uniqueInstance;
    }
// Другие методы
}
