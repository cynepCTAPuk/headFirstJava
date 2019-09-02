package chap09_Collections.smallCollections;

import java.util.*;

public class SmallCollectionsTest {
    public static void main(String[] args) {
        List<String> names1 = List.of("Peter", "Paul", "Mary");
        System.out.println("list: " + names1);
//        names1.add("CTAPuk"); // java.lang.UnsupportedOperationException

        Set<Integer> numbers1 = Set.of(1, 2, 3);
        System.out.println("set:  " + numbers1);

        Map<String, Integer> scores1 = Map.of("Peter", 1, "Paul", 2, "Mary", 3);
        System.out.println("1: " + scores1.keySet() + ":" + scores1.values());
        Map<Integer, String> scores2 = Map.of(1, "Peter", 2, "Paul", 3, "Mary");
        System.out.println("2: " + scores2.keySet() + ":" + scores2.values());

        var names2 = new TreeSet<>(names1);
        System.out.println(names2);
        names2.add("CTAPuk");
        System.out.println(names2);

        var numbers2 = new ArrayList<>(numbers1);
        System.out.println(numbers2);
        numbers2.add(4);
        System.out.println(numbers2);

        Map<String, Integer> scores = Map.ofEntries(
                Map.entry("Peter", 2),
                Map.entry("Paul", 3),
                Map.entry("Mary", 5));
//        scores.put("CTAPuk", 7); // java.lang.UnsupportedOperationException
        System.out.println(scores);

        List<String> settings = Collections.nCopies(100, "DEFAULT");
    }
}
