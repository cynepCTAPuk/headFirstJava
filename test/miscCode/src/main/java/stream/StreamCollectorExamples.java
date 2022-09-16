package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamCollectorExamples {
    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        System.out.println("Суммируем нечётные числа: " +
                numbers.stream()
                        .collect(Collectors.summingInt(((p) -> p % 2 == 1 ? p : 0))));
        System.out.println("Вычисляем среднее предварительно вычитая 1 у каждого числа: " +
                numbers.stream()
                        .collect(Collectors.averagingInt((p) -> p - 1)));
        System.out.println(
                numbers.stream()
                        .collect(Collectors.summarizingInt((p) -> p + 3)));
        System.out.println("Делим на две группы, чёт - нечёт " +
                numbers.stream()
                        .collect(Collectors.partitioningBy((p) -> p % 2 == 0)));

        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
        strings.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(
                strings.stream()
                        .distinct()
                        .map(String::toUpperCase)
                        .toArray(String[]::new)));
        System.out.println(
                strings.stream()
                        .collect(Collectors.joining(": ", "<b> ", " </b>")));
        System.out.println(
                strings.stream()
                        .distinct()
                        .collect(Collectors.toMap((p) -> p.substring(0, 1), (p) -> p.substring(1, 2))));
        System.out.println(
                strings.stream()
                        .collect(Collectors.groupingBy((p) -> p.substring(0, 1))));
        System.out.println(
                strings.stream()
                        .collect(Collectors.groupingBy((p) -> p.substring(0, 1),
                                Collectors.mapping((p) -> p.substring(1, 2),
                                        Collectors.joining(":")))));
    }
}
