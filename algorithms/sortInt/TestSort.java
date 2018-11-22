package sortInt;

import tools.*;

import java.util.*;

public class TestSort {
  public static void main(String[] args) {
    double t0;
    int[] array = new int[127];
    Utils.fillRandom(array);
    int arrayBubble[] = array.clone();
    int arrayInsertion1[] = array.clone();
    int arrayInsertion2[] = array.clone();
    int arrayOddEven[] = array.clone();
    int arraySelection[] = array.clone();
    int arrayShake[] = array.clone();

    t0 = System.nanoTime();
    Bubble.sort(arrayBubble);
    double tBubble = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Insertion1.sort(arrayInsertion1);
    double tInsertion1 = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Insertion2.sort(arrayInsertion2);
    double tInsertion2 = System.nanoTime() - t0;

    t0 = System.nanoTime();
    OddEven.sort(arrayOddEven);
    double tOddEven = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Selection.sort(arraySelection);
    double tSelection = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Shake.sort(arrayShake);
    double tShake = System.nanoTime() - t0;

    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(arrayBubble));
//    System.out.println(Arrays.toString(arrayInsertion1));
//    System.out.println(Arrays.toString(arrayInsertion2));
//    System.out.println(Arrays.toString(arraySelection));
//    System.out.println(Arrays.toString(arrayShake));

    System.out.println(String.format("Bubble\t\ttime nanoseconds\t%,.0f", tBubble));
    System.out.println(String.format("Insertion1\ttime nanoseconds\t%,.0f", tInsertion1));
    System.out.println(String.format("Insertion2\ttime nanoseconds\t%,.0f", tInsertion2));
    System.out.println(String.format("OddEven\t\ttime nanoseconds\t%,.0f", tOddEven));
    System.out.println(String.format("Selection\ttime nanoseconds\t%,.0f", tSelection));
    System.out.println(String.format("Shake\t\ttime nanoseconds\t%,.0f", tShake));

    System.out.println(Binary.search(arrayBubble, 50));
  }

}