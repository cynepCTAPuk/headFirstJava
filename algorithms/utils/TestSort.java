package utils;

public class TestSort {
  public static void main(String[] args) {
    double t0;
    int[] array = new int[10_000];
    Utils.fillRandom(array);
    int arrayBubble[] = array.clone();
    int arrayShake[] = array.clone();
    int arrayShakeTest[] = array.clone();
/*
    System.out.println(Arrays.toString(array));
    t0 = System.nanoTime();
    Arrays.sort(array);
    double tASort = System.nanoTime() - t0;
    System.out.println(Arrays.toString(array));
*/
    t0 = System.nanoTime();
    Bubble.sort(arrayBubble);
    double tBuble = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Shake1.sort(arrayShake);
    double tShake1 = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Shake2.sort(arrayShakeTest);
    double tShake2 = System.nanoTime() - t0;

    System.out.println(String.format("Bubble\ttime nanoseconds\t%,.0f", tBuble));
    System.out.println(String.format("Shake1\ttime nanoseconds\t%,.0f", tShake1));
    System.out.println(String.format("Shake2\ttime nanoseconds\t%,.0f", tShake2));
  }
}
