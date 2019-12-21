package designPatterns.singleton;

public class Singleton0 {
    private static Singleton0 instance;

    private Singleton0() {
    }

    public static Singleton0 getInstance() {
        if (instance == null) {
            instance = new Singleton0();
        }
        return instance;
    }

    public void print() {
        System.out.println(this);
    }
}
