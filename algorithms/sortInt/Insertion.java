package sortInt;

import java.util.*;

public class Insertion {

  public static void sortA(int[] array) {
    int right = 1;

    while (right < array.length) {
      for (int i = 0; i < right; i++) {
        if (array[right] <= array[i]) {
          int swap = array[right];
          for (int j = right; j > i; j--) {
            array[j] = array[j - 1];
          }
          array[i] = swap;
        }
      }
      right++;
    }
  }

  public static void sortB(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int temp = array[i];
      int j = i;
      while (j > 0 && array[j - 1] > temp) {
        array[j] = array[j - 1];
        --j;
      }
      array[j] = temp;
    }
  }

  public static void main(String[] args) {
    int size = 60;
    int[] arrayA = new int[size];
    int[] arrayB = new int[size];

    for (int i = 0; i < size - 1; i++) {
      int n = (int) (Math.random() * size);
      arrayA[i] = n;
      arrayB[i] = n;
    }

    System.out.println(Arrays.toString(arrayA));
    double t0 = System.nanoTime();
    Insertion.sortA(arrayA);
    double tInsA = System.nanoTime() - t0;
    System.out.println(Arrays.toString(arrayA));
    System.out.println(String.format("tInsA\t\ttime nanoseconds\t%,.0f", tInsA));

    System.out.println(Arrays.toString(arrayB));
    t0 = System.nanoTime();
    Insertion.sortB(arrayB);
    double tInsB = System.nanoTime() - t0;
    System.out.println(Arrays.toString(arrayB));
    System.out.println(String.format("tInsB\t\ttime nanoseconds\t%,.0f", tInsB));
  }
}
