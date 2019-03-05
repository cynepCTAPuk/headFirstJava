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
    int[] array = new int[size];

    for (int i = 0; i < size - 1; i++) {
      int n = (int) (Math.random() * size);
      array[i] = n;
    }

    System.out.println(Arrays.toString(array));
    double t0 = System.nanoTime();
    Insertion.sort(array);
    double tInsB = System.nanoTime() - t0;
    System.out.println(Arrays.toString(array));
    System.out.println(String.format("tInsB\t\ttime nanoseconds\t%,.0f", tInsB));
  }
}
