package Tools;

import java.util.Arrays;

public class TestSort {
  public static void main(String[] args) {
    int[] array = new int[50];
    Utils.fillRandom(array);
    System.out.println(Arrays.toString(array));
    int arrayBubble[] = array.clone();
    int arrayOddEven[] = array.clone();
    int arrayShake[] = array.clone();

    double t0 = System.nanoTime();
    Bubble.sort(arrayBubble);
    double tBubble = System.nanoTime() - t0;
    System.out.println(Arrays.toString(arrayBubble));

    t0 = System.nanoTime();
    OddEven.sort(arrayOddEven);
    double tOddEven = System.nanoTime() - t0;
    System.out.println(Arrays.toString(arrayOddEven));

    t0 = System.nanoTime();
    Shake.sort(arrayShake);
    double tShake = System.nanoTime() - t0;
    System.out.println(Arrays.toString(arrayShake));

    System.out.println(String.format("Bubble\ttime nanoseconds\t%,.0f", tBubble));
    System.out.println(String.format("OddEven\ttime nanoseconds\t%,.0f", tOddEven));
    System.out.println(String.format("Shake\ttime nanoseconds\t%,.0f", tShake));
  }
}
