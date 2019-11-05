/**
 * 3.2. Обернутые потоки
 * Проблема:
 * Требуется создать коллекцию из потока значений примитивных типов.
 * Решение:
 * Использовать метод boxed интерфейса Stream для обертывания элементов.
 * Можно вместо этого отобразить значения, пользуясь подходящим классом-оберткой,
 * или воспользоваться вариантом метода collect с тремя аргументами.
 */
package chap03_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {
        List<String> strings = Stream.of("this", "is", "a", "list", "of", "strings")
                .collect(Collectors.toList());

        List<Integer> ints;
        ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .boxed() // 
                .collect(Collectors.toList()); //  Преобразует int в Integer
        ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);

        int[] intArray = IntStream.of(3, 1, 4, 1, 5, 9).toArray();
    }
}
