/**
 * Джошуа Блох 3-е издание
 * 2.3. Получайте синглтоны с помощью закрытого конструктора или типа перечисления
 */
package designPatterns.singleton;

public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public void print() {
        System.out.println(this);
    }
}
