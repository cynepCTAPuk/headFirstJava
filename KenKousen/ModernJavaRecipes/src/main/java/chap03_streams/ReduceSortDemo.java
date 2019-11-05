/**
 * 3.4. Проверка правильности сортировки с помощью редукции
 * Проблема:
 * Требуется проверить, отсортирован ли поток.
 * Решение:
 * Использовать метод reduce для проверки пар соседних элементов.
 */
package chap03_streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ReduceSortDemo {
    public static void main(String[] args) {
        BigDecimal total = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val)); // 
        System.out.println("Сумма равна " + total);
        // Использование метода add класса BigDecimal в качестве BinaryOperator

        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList());
        //  Получается [“a”, “is”, “of”, “this”, “list”, “strings”]
        System.out.println(sorted);
    }
}
