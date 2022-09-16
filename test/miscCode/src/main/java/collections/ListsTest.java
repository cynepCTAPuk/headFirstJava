package collections;

import java.util.*;
import java.util.stream.Collectors;

public class ListsTest {
    public static void main(String[] args) {
        List<Double> d1 = Arrays.asList(2.0, 2.1, 2.2, 2.3, 2.4, 2.5);
        List<Double> d2 = Arrays.asList(2.0, 2.1, 2.2, 2.3, 2.4, 2.5);
        List<Double> d3 = Arrays.asList(2.0, 2.1, 2.2, 2.3, 2.4, 2.5);
        List<Double> d4 = Arrays.asList(2.0, 2.1, 2.2, 2.3, 2.4, 2.5);
        List<Double> d5 = Arrays.asList(2.0, 2.1, 2.2, 2.3, 2.4, 2.5);

        List<List<Double>> d = new ArrayList<>();
        d.add(d1);
        d.add(d2);
        d.add(d3);
        d.add(d4);
        d.add(d5);

        Map<Double, Long> map = d.stream().flatMap(List::stream).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(map);
        map.entrySet().stream().filter(e -> e.getValue() == d.size()).forEach(System.out::println);
    }
}
