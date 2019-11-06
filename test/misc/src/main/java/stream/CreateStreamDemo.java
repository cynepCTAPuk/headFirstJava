/**
 * https://habr.com/ru/company/luxoft/blog/270383/
 * Шпаргалка Java программиста 4. Java Stream API
 */
package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) throws IOException {
//        1. Классический: Создание стрима из коллекции	collection.stream()
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();

//        2. Создание стрима из значений
//        Stream.of(значение1,…   значениеN)
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

//        3. Создание стрима из массива	Arrays.stream(массив)
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);

//        4. Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
//        Files.lines(путь_к_файлу)
        Stream<String> streamFromFiles = Files.lines(Paths.get("c:/000/file.txt"));
        System.out.println(streamFromFiles
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList()));

//        5. Создание стрима из строки
//        «строка».chars()
        IntStream streamFromString = "123".chars();

//        6. С помощью Stream.builder
//        Stream.builder().add(...)....build()
        System.out.println(Stream.builder().add("a1").add("a2").add("a3").build()
                .collect(Collectors.toList()));

//        7. Создание параллельного стрима
//        collection.parallelStream()
        Stream<String> stream = collection.parallelStream();

//        8. Создание бесконечных стрима с помощью Stream.iterate
//        Stream.iterate(начальное_условие, выражение_генерации)
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);

//        9. Создание бесконечных стрима с помощью Stream.generate
//        Stream.generate(выражение_генерации)
        Stream<Double> streamFromGenerate1 = Stream.generate(Math::random);
        Stream<String> streamFromGenerate2 = Stream.generate(() -> "a1");
    }
}
