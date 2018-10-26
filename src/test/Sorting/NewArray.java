package test.Sorting;

import java.util.Arrays;
import java.util.Random;

public class NewArray {
    static void fillRandom(int[] array) {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) array[i] = rnd.nextInt(100);
    }

    public static void main(String[] args) {
        double t0;
        int[] array1 = new int[100_000];
        int[] array2 = new int[1_000_000];
        int[] array3 = new int[10_000_000];

        t0 = System.nanoTime();
        fillRandom(array1);
        System.out.println(String.format("%,.0f", System.nanoTime()-t0));

        t0 = System.nanoTime();
        fillRandom(array2);
        System.out.println(String.format("%,.0f", System.nanoTime()-t0));

        t0 = System.nanoTime();
        fillRandom(array3);
        System.out.println(String.format("%,.0f", System.nanoTime()-t0));
/*
        t0 = System.nanoTime();
        Bubble.sort(array1);
        t1 = System.nanoTime()-t0;
        System.out.println(String.format("%,.0f", t1));
*/

//        System.out.println(Arrays.toString(array1));
    }
}
