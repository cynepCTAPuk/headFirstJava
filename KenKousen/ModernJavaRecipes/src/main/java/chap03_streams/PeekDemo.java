/**
 * 3.5. Отладка потоков с помощью peek
 * Проблема:
 * Требуется видеть отдельные элементы потока по мере их обработки.
 * Решение:
 * Вставить в нужное место потока промежуточную операцию peek.
 */
package chap03_streams;

import java.util.stream.IntStream;

public class PeekDemo {
    public static void main(String[] args) {
        int sum = sumDoublesDivisibleBy3(1, 10);
        System.out.println();
        System.out.println(sum);
        sum = sumDoublesDivisibleBy3New(1, 10);
        System.out.println(sum);
    }

    public static int sumDoublesDivisibleBy3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(n -> n * 2)
                .map(n -> {
                    System.out.print(n + " ");
                    return n;
                })
                .filter(n -> n % 3 == 0)
                .sum();
    }

    public static int sumDoublesDivisibleBy3New(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .peek(n -> System.out.printf("original: %d%n", n)) // 
                .map(n -> n * 2)
                .peek(n -> System.out.printf("doubled : %d%n", n)) // 
                .filter(n -> n % 3 == 0)
                .peek(n -> System.out.printf("filtered: %d%n", n)) // 
                .sum();
    }
    // Печатать значение до удвоения
    //  Печатать значение после удвоения, но до фильтрации
    //  Печатать значение после фильтрации, но до суммирования
}
