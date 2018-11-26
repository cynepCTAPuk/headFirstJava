package sortInt;

import java.util.*;

public class Insertion {

  public static void sort(int[] array) {
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
    int[] arrayB = new int[size];

    for (int i = 0; i < size - 1; i++) {
      int n = (int) (Math.random() * size);
      arrayB[i] = n;
    }

    System.out.println(Arrays.toString(arrayB));
    double t0 = System.nanoTime();
    Insertion.sort(arrayB);
    double tInsB = System.nanoTime() - t0;
    System.out.println(Arrays.toString(arrayB));
    System.out.println(String.format("tInsB\t\ttime nanoseconds\t%,.0f", tInsB));
  }
}
