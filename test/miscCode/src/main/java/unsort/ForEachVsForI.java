package unsort;

import java.util.*;
import java.util.stream.*;

public class ForEachVsForI {
    public static void main(String[] args) {
        double t0;
        double t1;
        int maxSize = 30;                       // array size
        System.out.println(String.format("Кол-во элементов = %,d", maxSize));

        int[] arr = new int[maxSize];       // reference to array & create the array
        for (int i = 0; i < maxSize; i++) { // fill array with random numbers
            int n = (int) (10 + Math.random() * (99 - 10));
            arr[i] = n;
        }

        t0 = System.nanoTime();
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
        t1 = System.nanoTime();
        System.out.format("Print For\tnanoseconds =\t%,.0f %n", t1 - t0);

        t0 = System.nanoTime();
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        t1 = System.nanoTime();
        System.out.format("Print ForEach\tnanoseconds =\t%,.0f %n", t1 - t0);

        t0 = System.nanoTime();
        Arrays.stream(arr).mapToObj(i -> i + " ").forEachOrdered(System.out::print);
        System.out.println();
        t1 = System.nanoTime();
        System.out.format("Print Arrays.stream.forEachOrdered\tnanoseconds =\t%,.0f %n", t1 - t0);

    }
}
