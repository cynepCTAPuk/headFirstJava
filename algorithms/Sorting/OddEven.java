package Sorting;

import Tools.Utils;

import java.util.Arrays;

public class OddEven {
  public static void sort(int[] array) {
    int left, right = array.length - 1;
    boolean condition = true;

    while (condition) {
      condition = false;
      left = 0;
      for (int i = left; i < right; i = i + 2) {
        if (array[i] > array[i + 1]) {
          condition = true;
          int swap = array[i];
          array[i] = array[i + 1];
          array[i + 1] = swap;
        }
      }
      left = 1;
      for (int i = left; i < right; i = i + 2) {
        if (array[i] > array[i + 1]) {
          condition = true;
          int swap = array[i];
          array[i] = array[i + 1];
          array[i + 1] = swap;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] array = new int[50];
    Utils.fillRandom(array);
    System.out.println(Arrays.toString(array));
    OddEven.sort(array);
    System.out.println(Arrays.toString(array));
  }
}