package stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        System.out.println(getIntegers());
//        List<String> list = Arrays.asList("a1", "b2", "c3"); // Java 8 fix size
//        List<String> list = List.of("a1", "b2", "c3"); // Java 9 fix size
//        List<String> list = new ArrayList<>() {{add("a1");add("b2");add("c3");}}; // Java 8
//        List<String> list = new ArrayList<>(Arrays.asList("a1", "b2", "c3")); // Java 8
//        List<String> list = Stream.of("a1", "b2", "c3").collect(Collectors.toList()); //Java 8

/*
        List<String> list = new ArrayList<>(); // Java 8
        Collections.addAll(list, "0a1", "_b2", "c3");
        list.add("d4");
        System.out.println(getResult_imperative(list));
        System.out.println(getResult_Declarative(list));
*/
    }

    private static List<Integer> getIntegers() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Integer> list = Stream
                .generate(atomicInteger::getAndIncrement)
//                .iterate(0, i -> i + 1)
                .limit(10)
                .collect(Collectors.toList());
        return list;
    }

    private static int getResult_imperative(List<String> strings) {
        int result = 0;
        for (String string : strings) {
            if (Character.isDigit(string.charAt(0))) continue;
            if (string.contains("_")) continue;
            result += string.length();
        }
        return result;
    }

    private static int getResult_Declarative(List<String> strings) {
        return strings.
                stream().
                filter(s -> !Character.isDigit(s.charAt(0))).
                filter(s -> !s.contains("_")).
                mapToInt(String::length).
                sum();
    }
}
