package test.Sorting;

import test.MyMath;

import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;

public class TestSorting {
    public static void main(String[] args) {
        double t0, tBublle, tShake;
        int[] array = new int[10_000];
        NewArray.fillRandom(array);
//        System.out.println(Arrays.toString(array));
        int[] arrayBubble = array.clone();

        int[] arrayShake = array.clone();

        int[] array3 = array.clone();

        t0 = System.nanoTime();
        Bubble.sort(arrayBubble);
        tBublle = System.nanoTime() - t0;
        System.out.println("Bublle\t" + String.format("%,.0f", tBublle));

        t0 = System.nanoTime();
        Shake.sort(arrayShake);
        tShake = System.nanoTime() - t0;
        System.out.println("Shake\t" + String.format("%,.0f", tShake));
    }

}
