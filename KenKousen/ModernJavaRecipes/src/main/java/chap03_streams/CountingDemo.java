/**
 * 3.7. Подсчет элементов
 * Проблема:
 * Требуется узнать, сколько элементов в потоке.
 * Решение:
 * Использовать метод Stream.count или Collectors.counting.
 */
package chap03_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingDemo {
    public static void main(String[] args) {
        long count;
        count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .count();
        System.out.printf("В потоке %d элементов%n", count);

        count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .collect(Collectors.counting());
        System.out.printf("В потоке %d элементов%n", count);

        List<String> strings = Arrays.asList("This", "is", "winter");
        Map<Boolean, Long> numberLengthMap = strings.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() % 3 == 0, // 
                        Collectors.counting())); // 
        numberLengthMap.forEach((k, v) -> System.out.printf("%5s: %d%n", k, v));
        // false: 4
        // true: 8
        // Предикат
        // Подчиненный коллектор
    }
}
