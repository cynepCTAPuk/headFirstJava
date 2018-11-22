package sortInt;

import tools.*;

import java.util.*;

public class Binary {
  public static int search(int[] array, int key) {
    int left = 0;
    int right = array.length - 1;
    int count = 0;
    int median = (left + right) >>> 1;
    while (left < right) {
      System.out.println("Number of cycle = " + ++count + "\tMiddle of array = " + median);
      if (array[median] == key) {
        System.out.println("\t\t-=Place of key " + key + " is " + median + "=-");
        return median;
      }
      if (key > array[median]) {
        left = median + 1;
        median = (left + right) >>> 1;
      }
      if (key < array[median]) {
        right = median - 1;
        median = (left + right) >>> 1;
      }
    }
    System.out.println("\t\tNo key = " + key);
    return -1;
  }

  public static void main(String[] args) {
    Random random = new Random();
    int[] array = new int[30];
    Utils.fillRandom100(array);
//    System.out.println(Arrays.toString(array));
    Arrays.sort(array);
    System.out.println(Arrays.toString(array));

    search(array, 0);
    search(array, random.nextInt(99));
    search(array, 99);
  }
}
