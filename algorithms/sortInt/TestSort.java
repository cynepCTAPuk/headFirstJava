package sortInt;

import tools.*;

public class TestSort {
  public static void main(String[] args) {
    double t0;
    int nElements = 10_000;
    int[] array = new int[nElements];
    Utils.fillRandom100(array);
    System.out.println(String.format("Кол-во элементов = %,d", nElements));
    int arrayBubble[] = array.clone();
    int arrayInsertA[] = array.clone();
    int arrayInsertB[] = array.clone();
    int arrayOddEven[] = array.clone();
    int arraySelection[] = array.clone();
    int arrayShake[] = array.clone();

    t0 = System.nanoTime();
    Bubble.sort(arrayBubble);
    double tBubble = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Insertion.sortA(arrayInsertA);
    double tInsertA = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Insertion.sortB(arrayInsertB);
    double tInsertB = System.nanoTime() - t0;

    t0 = System.nanoTime();
    OddEven.sort(arrayOddEven);
    double tOddEven = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Selection.sort(arraySelection);
    double tSelection = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Shake.sort(arrayShake);
    double tShake = System.nanoTime() - t0;

    System.out.println(String.format("Bubble\t\ttime nanoseconds\t%,.0f", tBubble));
    System.out.println(String.format("InsertA\t\ttime nanoseconds\t%,.0f", tInsertA));
    System.out.println(String.format("InsertB\t\ttime nanoseconds\t%,.0f", tInsertB));
    System.out.println(String.format("OddEven\t\ttime nanoseconds\t%,.0f", tOddEven));
    System.out.println(String.format("Selection\ttime nanoseconds\t%,.0f", tSelection));
    System.out.println(String.format("Shake\t\ttime nanoseconds\t%,.0f", tShake));
  }
}