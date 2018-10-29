package test.Sorting;

import test.MyMath;

import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TestSorting {
    public static void main(String[] args) {
        double t0, tBubble, tShake, tShakeClassic, tOddEven;
        int[] array = new int[10_000];
        NewArray.fillRandom(array);
        int[] arrayBubble, arrayShake, arrayShakeClassic, arrayOddEven;

        arrayBubble = array.clone();
        arrayShake = array.clone();
        arrayShakeClassic = array.clone();
        arrayOddEven = array.clone();

        t0 = System.nanoTime();
        Bubble.sort(arrayBubble);
        tBubble = System.nanoTime() - t0;

        t0 = System.nanoTime();
        Shake.sort(arrayShake);
        tShake = System.nanoTime() - t0;

        t0 = System.nanoTime();
        ShakeClassic.sort(arrayShakeClassic);
        tShakeClassic = System.nanoTime() - t0;

        t0 = System.nanoTime();
        OddEven.sort(arrayOddEven);
        tOddEven = System.nanoTime() - t0;
/*
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayBubble));
        System.out.println(Arrays.toString(arrayShake));
        System.out.println(Arrays.toString(arrayOddEven));
*/
        System.out.println();
        System.out.println("Bubble\t" + String.format("%,.0f", tBubble));
        System.out.println("Shake\t" + String.format("%,.0f", tShake));
        System.out.println("ShakeClassic\t" + String.format("%,.0f", tShakeClassic));
        System.out.println("OddEven\t" + String.format("%,.0f", tOddEven));
    }
}
