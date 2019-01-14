package chap11;

//: holding/SetOfInteger.java

import java.util.*;

public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intSet = new HashSet<>();
        int rnd;
        for (int i = 0; i < 40; i++) {
            rnd = rand.nextInt(20);
            System.out.print(rnd + " ");
            intSet.add(rnd);
        }
        System.out.println();
        Iterator<Integer> it = intSet.iterator();
        while(it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();
        System.out.println(intSet);
    }
} /* Output:
[15, 8, 23, 16, 7, 22, 9, 21, 6, 1, 29, 14, 24, 4, 19, 26, 11, 18, 3, 12, 27, 17, 2, 13, 28, 20, 25, 10, 5, 0]
*///:~