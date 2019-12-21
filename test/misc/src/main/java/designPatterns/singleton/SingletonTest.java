package designPatterns.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton0.getInstance().print();
        Singleton1.INSTANCE.print();
        Singleton2.getInstance().print();
        Singleton3.INSTANCE.print();
    }
}
