package chap09_Collections.smallCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallCollectionsTest {
    public static void main(String[] args) {
        List<String> names1 = List.of("Peter", "Paul", "Mary");
        System.out.println(names1);
//        names1.add("CTAPuk"); // java.lang.UnsupportedOperationException
        Set<Integer> numbers = Set.of(1, 2, 3);
        System.out.println(numbers);
        Map<String, Integer> scores1 = Map.of("Peter", 1, "Paul", 2, "Mary", 3);
        System.out.print("1: ");
        System.out.print(scores1.keySet());
        System.out.println(scores1.values());

        Map<Integer, String> scores2 = Map.of(1, "Peter", 2, "Paul", 3, "Mary");
        System.out.print("2: ");
        System.out.print(scores2.keySet());
        System.out.println(scores2.values());

        var names2 = new ArrayList<>(List.of("Peter", "Paul", "Mary"));
        System.out.println(names2);
        names2.add("CTAPuk");
        System.out.println(names2);
        var names3 = new ArrayList<>(numbers);
        System.out.println(names3);
    }
}
