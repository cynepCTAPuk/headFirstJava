package chap11_holding;

import java.util.*;

public class Exercise12 {
    public static void main(String[] args) {
        List<Integer> int1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> int2 = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5));
        System.out.println(int1);
        System.out.println(int2);

        ListIterator<Integer> listIT = int1.listIterator(int1.size());

        while (listIT.hasPrevious()) int2.add(listIT.previous());
        System.out.println(int2);

    }
}
