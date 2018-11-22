package sortInt;

import tools.Utils;

import java.util.Arrays;

public class Bubble {
  public static void sort(int[] array) {
    int left = 0, right = array.length - 1;

    while (left < right) {
      for (int i = left; i < right; i++) {
        if (array[i] > array[i + 1]) {
          int swap = array[i];
          array[i] = array[i + 1];
          array[i + 1] = swap;
        }
      }
      right--;
    }
  }

  public static void main(String[] args) {
    int[] array = new int[50];
    Utils.fillRandom100(array);
    System.out.println(Arrays.toString(array));
    Bubble.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
