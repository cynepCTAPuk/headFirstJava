package org.stepic.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamTest {
    public static void main(String[] args) {
        int[] array = IntStream
                .iterate(1, n -> n + 1)
                .filter(n -> n % 5 == 0 && n % 2 != 0)
                .limit(10)
                .map(n -> n * n)
                .toArray();
        System.out.println(Arrays.toString(array));

        int sum = IntStream
                .iterate(1, n -> n + 1)
                .filter(n -> n % 5 == 0 && n % 2 != 0)
                .limit(10)
                .map(n -> n * n)
                .sum();
        System.out.println(sum);

        List<Integer> list = Stream
                .iterate(1, n -> n + 1)
                .filter(n -> n % 5 == 0 && n % 2 != 0)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(list);

        IntStream smallIntegers = IntStream.range(0, 30);
        list = smallIntegers.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list);

        IntStream smallIntegers1 = IntStream.rangeClosed(0, 30);
        list = smallIntegers1.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list);

        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        String string = String.join(" ", givenList);
        System.out.println(string);

        IntStream smallIntegers2 = IntStream.range(0, 30);
        string = smallIntegers2
//                .mapToObj(String::valueOf)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(string);
    }
}
