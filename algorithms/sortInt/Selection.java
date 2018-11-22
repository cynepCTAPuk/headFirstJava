package sortInt;

import tools.Utils;

import java.util.Arrays;

public class Selection {
  public static void sort(int[] array) {
    int left = 0, right = array.length - 1;

    while (left < right) {
      int min = left;
      for (int i = left; i < right; i++) {
        if (array[min] > array[i+1]) {
          min = i + 1;
        }
      }
      int swap = array[left];
      array[left] = array[min];
      array[min] = swap;
      left++;
    }
  }

  public static void main(String[] args) {
    int[] array = new int[50];
    Utils.fillRandom(array);
    System.out.println(Arrays.toString(array));
    Selection.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
