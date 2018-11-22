package sortInt;

import tools.Utils;

import java.util.Arrays;

public class Insertion1 {
  public static void sort(int[] array) {
    int right = 1;

    while (right < array.length) {
      for (int i = 0; i < right; i++) {
        if (array[right] <= array[i]) {
          int swap = array[right];
          for (int j = right; j > i; j--) array[j] = array[j - 1];
          array[i] = swap;
        }
      }
      right++;
    }
  }

  public static void main(String[] args) {
    int[] array = new int[50];
    Utils.fillRandom(array);
    System.out.println(Arrays.toString(array));
    Insertion1.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
