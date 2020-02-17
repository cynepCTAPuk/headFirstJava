package shortPuzzles;

import java.util.Set;
import java.util.TreeSet;

public class NumberTest {
    public static void main(String[] args) {
        Set<Number> set = new TreeSet<>();
        set.add(1);
        set.add(1L);
        // java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.Long
        set.add(1.0);
    }
}
