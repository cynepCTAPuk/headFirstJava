package collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
    private static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("/u000a");
        set.add("/u000b");
        set.add("/u000c");
        set.add("1");
        set.add("2");
        set.add("3");
        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}
