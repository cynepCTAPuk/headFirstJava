package utils;

import java.util.Iterator;
import java.util.Random;

public class UtilsAlgorithms {
  public static void fillRandom(int[] array) {
    Random rnd = new Random();
    for (int i = 0; i < array.length; i++) array[i] = rnd.nextInt(100);
  }

  public static void swap(int[] array, int x, int y) {
    int swap = array[x];
    array[x] = array[y];
    array[y] = swap;
  }

  public static void print(int[] toPrint) {
    System.out.print("[");
    int size = toPrint.length;
    for (int i = 0; i < size; i++) {
      if (i == size - 1) System.out.print(toPrint[i] + "]");
      else System.out.print(toPrint[i] + ", ");
    }
    System.out.println();
  }

  public static void printV(int[] one, int[] two) {
    System.out.println("<-|\t|->");
    if (one.length == two.length) {
      for (int i = 0; i < one.length; i++) System.out.println(one[i] + "\t" + two[i]);
    } else System.out.println("Length of arrays must be equal!");
  }

  public static void printB(int[] array) {
    for (int i : array) System.out.print(i + " ");
  }
}
