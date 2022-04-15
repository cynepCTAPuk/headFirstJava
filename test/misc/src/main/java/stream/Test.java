package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 2, 3, 4, 5, 6);
//        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
//        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(list);
        list.sort(Integer::compareTo);
        System.out.println(list);

        List<Integer> collect;
        collect = list.stream().filter(a -> a > 3).collect(Collectors.toList());
        System.out.println(collect);

//        new Random().ints().limit(5).sorted().forEach(System.out::println);
//        LongStream longStream = new Random().longs().limit(5);
//        longStream.sorted().filter(a -> a > 0).forEach(x -> System.out.format(new Locale("ru"),"%,27d %n", x));
    }
}
