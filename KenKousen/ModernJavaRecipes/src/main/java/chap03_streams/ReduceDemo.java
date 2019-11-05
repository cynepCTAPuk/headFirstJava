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
import java.util.stream.IntStream;

public class ReduceDemo {
    public static void main(String[] args) {
        String[] strings = "this is an array of strings".split(" ");

        long count = Arrays.stream(strings)
                .map(String::length) // 
                .count();
        System.out.println("Всего существует " + count + " строк");

        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length) // 
                .sum();
        System.out.println("Суммарная длина равна " + totalLength);

        OptionalDouble ave = Arrays.stream(strings)
                .mapToInt(String::length) // 
                .average();
        System.out.println("Средняя длина равна " + ave);

        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length) // 
                .max(); // 
        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length) // 
                .min(); // 
        System.out.println("Максимальная и минимальная длины равны " + max + " и " + min);
        // count – метод Stream, поэтому необходимо преобразовать в IntStream
        // sum и average определены только для потоков значений примитивного типа
        // max и min без компаратора определены только для потоков значений примитивного типа

        int sum = IntStream.rangeClosed(1, 10)
//                .sum();
                .reduce((x, y) -> x + y).orElse(0); // Значение sum равно 55
        System.out.println(sum);

        sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%2d, y=%2d%n", x, y);
                    return x + y;
                }).orElse(0);

        int doubleSum;
        doubleSum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + 2 * y).orElse(0);
        //  Значение doubleSum равно 109 (плохо! ошибка на 1!)
        System.out.println(doubleSum);
        doubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> {
                    System.out.printf("x=%2d, y=%2d%n", x, y);
                    return x + 2 * y;
                });
        //  Значение doubleSum равно 110, как и должно быть
        System.out.println(doubleSum);
    }
}
