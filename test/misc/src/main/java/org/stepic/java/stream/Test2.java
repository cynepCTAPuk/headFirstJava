package org.stepic.java.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String[] words = reader.readLine()
                .toLowerCase()
                .split("[^a-zA-Z0-9а-яА-Я]+");

        Map<String, Integer> map = new HashMap<>();
//        Arrays.stream(words).forEach(s -> map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1));
        Arrays.stream(words).forEach(s -> map.merge(s.toLowerCase(), 1, Integer::sum));

        map.entrySet().stream()
                .sorted((o1, o2) -> {
                    int i = o2.getValue() - o1.getValue();
                    return i == 0 ? o1.getKey().compareTo(o2.getKey()) : i;
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));

/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        reader.lines()
                .map(words -> words.toLowerCase().split("[^а-я|А-Я|a-z|A-Z|0-9]+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(
                        String::toString,
                        TreeMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .forEach((line) -> System.out.println(line.getKey()));
*/
    }
}
