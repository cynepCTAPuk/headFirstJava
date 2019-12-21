/**
 * Джошуа Блох 3-е издание
 * 2.3. Получайте синглтоны с помощью закрытого конструктора или типа перечисления
 */
package designPatterns.singleton;

public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

    public void print() {
        System.out.println(this);
    }
}
