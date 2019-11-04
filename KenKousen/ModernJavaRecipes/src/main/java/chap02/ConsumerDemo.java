/**
 *  Реализация с анонимным внутренним классом
 *  Лямбда-выражение
 *  Ссылка на метод
 */
package chap02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("This", "is", "a", "list", "of", "strings");
        strings.forEach(new Consumer<String>() { // 
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.forEach(s -> System.out.println(s));// 
        strings.forEach(System.out::println); // 
    }
}
