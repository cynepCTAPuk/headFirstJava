package chap11_holding;

//: holding/AddingGroups.java
// Adding groups of elements to Collection objects.

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(c);
        Integer[] moreInts = {6, 7, 8, 9, 10};
        c.addAll(Arrays.asList(moreInts));
        System.out.println(c);

        // Runs significantly faster, but you can’t construct a Collection this way:
        Collections.addAll(c, 11, 12, 13, 14, 15);
        System.out.println(c);
        Collections.addAll(c, moreInts);
        System.out.println(c);

        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        System.out.println(list);
        list.set(1, 99); // OK -- modify an element
        System.out.println(list);

        // Runtime error because the underlying array cannot be resized.
        // java.lang.UnsupportedOperationException
//        list.add(21);
    }
} ///:~