package y21;

import java.util.Set;
import java.util.TreeSet;

public class Q210830_1 {
    private static Set<String> set = new TreeSet<>();
    public static void main(String... args) {
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("/u000a");
        set.add("/u000b");
        set.add("/u000c");
        set.add("1");
        set.add("2");
        set.add("3");
        for (String string : set) {
            System.out.print(string + " ");
        }
    }
}


