package sortInt;

import tools.*;

import java.util.*;

public class Insertion2 {
  public static void sort(int[] array) {

    for (int i = 1; i < array.length; i++) {
      int swap = array[i];
      while (i > 0 && swap < array[i - 1]) {
        array[i] = array[i - 1];
        i = i - 1;
      }
      array[i] = swap;
    }
  }

  public static void main(String[] args) {
    int[] array = new int[20];
    Utils.fillRandom(array);
    System.out.println(Arrays.toString(array));
    Insertion2.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
