package chap16_arrays;

import java.util.*;

public class Exercesi23 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[20];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = (int) (Math.random() * (100 - 10) + 1);
        }
        System.out.println(Arrays.toString(integers));

        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        
        Arrays.sort(integers,Comparator.reverseOrder());
        System.out.println(Arrays.toString(integers));
    }
}
