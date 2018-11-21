package Sorting;

import Tools.Utils;

public class TestSort {
  public static void main(String[] args) {
    int[] array = new int[10_000];
    Utils.fillRandom(array);
    int arrayBubble[] = array.clone();
    int arrayInsertion[] = array.clone();
    int arrayOddEven[] = array.clone();
    int arraySelection[] = array.clone();
    int arrayShake[] = array.clone();

    double t0 = System.nanoTime();
    Bubble.sort(arrayBubble);
    double tBubble = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Insertion.sort(arrayInsertion);
    double tInsertion = System.nanoTime() - t0;

    t0 = System.nanoTime();
    OddEven.sort(arrayOddEven);
    double tOddEven = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Selection.sort(arraySelection);
    double tSelection = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Shake.sort(arrayShake);
    double tShake = System.nanoTime() - t0;

   /* System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(arrayBubble));
    System.out.println(Arrays.toString(arrayOddEven));
    System.out.println(Arrays.toString(arraySelection));
    System.out.println(Arrays.toString(arrayShake));
   */
    System.out.println(String.format("Bubble\ttime nanoseconds\t%,.0f", tBubble));
    System.out.println(String.format("Insertion\ttime nanoseconds\t%,.0f", tInsertion));
    System.out.println(String.format("OddEven\ttime nanoseconds\t%,.0f", tOddEven));
    System.out.println(String.format("Selection\ttime nanoseconds\t%,.0f", tSelection));
    System.out.println(String.format("Shake\ttime nanoseconds\t%,.0f", tShake));
  }
}
