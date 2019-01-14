package chap11;

//: holding/SortedSetOfInteger.java

import java.util.*;

public class SortedSetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> intSet = new TreeSet<>();
        for (int i = 0; i < 10_000; i++) intSet.add(rand.nextInt(30));
        System.out.println(intSet);
    }
} /* Output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
*///:~