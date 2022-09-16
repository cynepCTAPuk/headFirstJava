package stream;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> first = System.out::println;
        first.accept("Anna");
        Consumer<String> second = name -> System.out.println("Second name " + name);
        second.accept("Kristina");
        Consumer<String> result = first.andThen(second);
        result.accept("Lisa");
    }
}
