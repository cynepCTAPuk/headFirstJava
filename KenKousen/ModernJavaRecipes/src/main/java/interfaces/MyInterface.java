package interfaces;

@FunctionalInterface
public interface MyInterface {
    int myMethod();

    default String sayHello() {
        return "Hello, World!";
    }

    static void myStaticMethod() {
        System.out.println("Это статистический метод интрефейса");
    }
}
