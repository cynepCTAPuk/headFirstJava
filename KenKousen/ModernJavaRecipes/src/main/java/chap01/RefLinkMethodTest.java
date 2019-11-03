package chap01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RefLinkMethodTest {
    public static void main(String[] args) {
        Stream.of(3, 1, 4, 1, 5, 9).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        });
        Stream.of(3, 1, 4, 1, 5, 9).filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));
        Stream.of(3, 1, 4, 1, 5, 9).filter(x -> x % 2 == 0).forEach(System.out::println);

        Consumer<Integer> printer = System.out::println;
        Stream.of(3, 1, 4, 1, 5, 9).filter(x -> x % 2 == 0).forEach(printer);

        System.out.println(Stream.of(3, 1, 4, 1, 5, 9).map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]")).toString());

        Stream.generate(Math::random).limit(2).forEach(System.out::println);

        List<Double> list = Stream.generate(Math::random).limit(5).collect(Collectors.toList());
        System.out.println(list);
        double max = 0;
        for (Double e : list) if (e > max) max = e;
        for (Double e : list) max = Math.max(e, max);
        System.out.println(max);

        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        System.out.println(sorted);

        List<String> strings1 = Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted1 = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Stream.of("this", "is", "a", "stream", "of", "strings")
                .map(String::length)
                .forEach(System.out::println);
    }
}
