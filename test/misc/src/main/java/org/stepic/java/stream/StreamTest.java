package org.stepic.java.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        Set<String> set;
//        set = new HashSet<>(Arrays.asList("a", "b", "c"));
//        set = Stream.of("d", "e", "f").collect(Collectors.toCollection(HashSet::new));
        set = Stream.of("g", "h", "i").collect(Collectors.toSet());
        set.add("j");
        System.out.println(set);
        System.out.println(set.getClass());

        Path path = Paths.get("c:/000");

        Stream<Path> stream1 = Files.list(path);
        List<Path> list1 = stream1.filter(x -> x.toString().endsWith(".png"))
                .collect(Collectors.toList());
        System.out.println(list1);

        Stream<Path> stream2 = Files.walk(path, 2);
        List<Path> list2 = stream2
                .filter(x -> x.toString().endsWith(".png"))
                .collect(Collectors.toList());
        System.out.println(list2);

        IntStream chars = (
                "0123456789"
//                        + "abcdefghijklmnoprqstuvwxyz"
//                        + "abcdefghijklmnoprqstuvwxyz".toUpperCase()
        )
                .chars();
        chars.forEach(x -> System.out.printf("%4s", x));
        System.out.println();

        DoubleStream randomNumbers = DoubleStream.generate(Math::random);
        randomNumbers.limit(5).forEach(System.out::println);

    }
}
