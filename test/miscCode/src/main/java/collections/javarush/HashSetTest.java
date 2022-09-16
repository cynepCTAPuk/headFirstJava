package collections.javarush;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1));
        System.out.println(set);
        List<Integer> list = new ArrayList<>(set);
        System.out.println(list);
        list.sort((a, b) -> b - a);
        System.out.println(list);
    }
}
