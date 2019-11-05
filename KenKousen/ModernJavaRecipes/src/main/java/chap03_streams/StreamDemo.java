/**
 * 3.1. Создание потоков
 * Проблема:
 * Требуется создать поток из источника данных.
 * Решение:
 * Использовать статические фабричные методы интерфейса Stream или метод stream интерфейса Iterable или класса Arrays.
 */
package chap03_streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        String names = StreamDemo.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(", "));
        System.out.println(names);

        String[] munsters = {"Herman", "Lily", "Eddie", "Marilyn", "Grandpa"};
        names = Arrays.stream(munsters)
                .collect(Collectors.joining(", "));
        System.out.println(names);

        List<BigDecimal> nums = Stream
                .iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(nums); // печатается [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        List<LocalDate> dates = Stream
                .iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(8)
                .collect(Collectors.toList());
//                .forEach(System.out::println);

        System.out.println(dates); // печатается 8 дней, начиная с сегодняшнего

        List<Double> rnds = Stream.generate(Math::random)
                .limit(5)
                .collect(Collectors.toList());
//                .forEach(System.out::println);
        System.out.println(rnds);

        List<String> bradyBunch = Arrays.asList("Greg", "Marcia", "Peter", "Jan", "Bobby", "Cindy");
        String bradies = bradyBunch.stream().collect(Collectors.joining(","));
        System.out.println(bradies); // печатается Greg,Marcia,Peter,Jan,Bobby,Cindy

        List<Integer> ints = IntStream.range(10, 15)
                .boxed() // 
                .collect(Collectors.toList());
        System.out.println(ints); // печатается [10, 11, 12, 13, 14]

        List<Long> longs = LongStream.rangeClosed(10, 15)
                .boxed() // 
                .collect(Collectors.toList());
        System.out.println(longs); // печатается [10, 11, 12, 13, 14, 15]
        //  Необходимо, чтобы коллектор мог преобразовать примитивы в List<T>
    }

    @SafeVarargs
    public static <T> Stream<T> of(T... values) {
        return Arrays.stream(values);
    }
}
