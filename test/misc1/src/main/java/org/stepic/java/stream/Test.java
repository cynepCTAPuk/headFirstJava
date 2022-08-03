package org.stepic.java.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        System.out.println(pseudoRandomStream(13)
                .mapToObj(Integer::toString)
                .limit(30)
                .collect(Collectors.joining(", ")));
        System.out.println();
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> n * n / 10 % 1000);
    }

    public static int mid(int n) {
        return n * n / 10 % 1000;
    }
}
