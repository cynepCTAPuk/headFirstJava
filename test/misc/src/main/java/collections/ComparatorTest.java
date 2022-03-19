package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.comparing(String::length).reversed();

//        Comparator<String> comparator = Comparator.comparing(s -> s.length()).reversed(); // oops
//        Comparator<String> comparator = Comparator.<String, Integer>comparing(s -> s.length()).reversed();
//        Comparator<String> comparator = Comparator.comparing((String s) -> s.length()).reversed();

//        Comparator<String> comparator = Collections.reverseOrder(Comparator.comparing(String::length));
//        Comparator<String> comparator = Collections.reverseOrder(Comparator.comparing(s -> s.length()));

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        System.out.println(list);
        list.sort(comparator);
        System.out.println(list);
    }
}
