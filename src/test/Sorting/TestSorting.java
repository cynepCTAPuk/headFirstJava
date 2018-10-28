package test.Sorting;

import test.MyMath;

import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;

public class TestSorting {
    public static void main(String[] args) {
        double t0, tBublle, tShake, tOddEven;
        int[] array = new int[1_000];
        NewArray.fillRandom(array);

        int[] arrayBubble = array.clone();
        int[] arrayShake = array.clone();
        int[] arrayOddEven = array.clone();

        t0 = System.nanoTime();
        Bubble.sort(arrayBubble);
        tBublle = System.nanoTime() - t0;

        t0 = System.nanoTime();
        Shake.sort(arrayShake);
        tShake = System.nanoTime() - t0;

        t0 = System.nanoTime();
        OddEven.sort(arrayOddEven);
        tOddEven = System.nanoTime() - t0;

/*
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayBubble));
        System.out.println(Arrays.toString(arrayShake));
        System.out.println(Arrays.toString(arrayOddEven));
*/

        System.out.println("Bublle\t" + String.format("%,.0f", tBublle));
        System.out.println("Shake\t" + String.format("%,.0f", tShake));
        System.out.println("OddEven\t" + String.format("%,.0f", tOddEven));
    }
}
