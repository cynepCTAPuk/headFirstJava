/**
 * 3.3. Операции редукции
 * Проблема:
 * Требуется получить одно значение в результате операций с потоком.
 * Решение:
 * Использовать метод reduce для аккумулирования результатов вычислений.
 */
package chap03_streams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceDemo1 {
    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        Integer max = Stream.of(3, 1, 4, 1, 5, 9)
                .reduce(Integer.MIN_VALUE, Integer::max);
        //  Нейтральным элементом max является минимальное целое число
        System.out.println("Максимальное значение равно " + max); //

        String s = Stream.of("this", "is", "a", "list")
                .reduce("", String::concat);
        System.out.println(s); //  Печатается thisisalist

        s = Stream.of("this", "is", "a", "list")
                .collect(() -> new StringBuilder(), // 
                        (sb, str) -> sb.append(str), // 
                        (sb1, sb2) -> sb1.append(sb2)) // 
                .toString();
        //  Поставщик результата
        //  Добавить к результату одно значение
        //  Объединить два результата
        System.out.println(s);

        s = Stream.of("this", "is", "a", "list")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();

        s = Stream.of("this", "is", "a", "list")
                .collect(Collectors.joining());


    }
}
