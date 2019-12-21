/**
 * Джошуа Блох 3-е издание
 * 2.3. Получайте синглтоны с помощью закрытого конструктора или типа перечисления
 */
package designPatterns.singleton;

public enum Singleton3 {
    INSTANCE;

    public void print() {
        System.out.println(this);
    }
}
