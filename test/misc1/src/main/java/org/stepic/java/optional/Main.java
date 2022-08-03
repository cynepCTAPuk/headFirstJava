package org.stepic.java.optional;

import java.util.Objects;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);

        Pair<Integer, String> pair3 = Pair.of(null, null);
        System.out.println(pair2.equals(pair3));
        System.out.println(pair3.getFirst());
        System.out.println(pair3.getSecond());

        pair.ifPresent((a, b) -> System.out.println(a + ":" + b));

    }
}

class Pair<U, V> {
    private final U first;
    private final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public void ifPresent(BiConsumer<? super U, ? super V> consumer) {
        if (first != null && second != null) {
            consumer.accept(first, second);
        }
    }

    public static <U, V> Pair<U, V> of(U first, V second) {
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}