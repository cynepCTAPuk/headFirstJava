package org.stepic.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        findMinMax(list.stream(),
        findMinMax(Stream.of(1, 2, 3, 4, 3, 2, 1, 0),
//        findMinMax(Stream.of('a','z'),
                Comparator.naturalOrder(),
                (a, b) -> System.out.println("min: " + a + "\n" + "max: " + b));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        minMaxConsumer
                .accept(list.stream().min(order).orElse(null),
                        list.stream().max(order).orElse(null));
    }

/*
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        Optional<T> min = list.stream().min(order);
        Optional<T> max = list.stream().max(order);
        minMaxConsumer.accept(min.get(), max.get());
    }
*/
}
