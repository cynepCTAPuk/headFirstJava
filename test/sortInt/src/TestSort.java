public class TestSort {
  public static void main(String[] args) {
    double t0;
    int nElements = 1_000_000;
    int[] array = new int[nElements];
    Utils.fillRandom100(array);
    System.out.println(String.format("Кол-во элементов = %,d", nElements));

/*
    int arrayBubble[] = array.clone();
    t0 = System.nanoTime();
    Bubble.sort(arrayBubble);
    System.out.println(String.format("Bubble\t\ttime nanoseconds\t%,12.0f", System.nanoTime() - t0));
*/

/*
    int arrayInsert[] = array.clone();
    t0 = System.currentTimeMillis();
    Insertion.sort(arrayInsert);
    System.out.println(String.format("Insertion\ttime milliseconds\t%,18.0f", System.currentTimeMillis() - t0));
*/

/*
    int arrayOddEven[] = array.clone();
    t0 = System.nanoTime();
    OddEven.sort(arrayOddEven);
    System.out.println(String.format("OddEven\t\ttime nanoseconds\t%,12.0f", System.nanoTime() - t0));
*/

/*
    int arraySelection[] = array.clone();
    t0 = System.nanoTime();
    Selection.sort(arraySelection);
    System.out.println(String.format("Selection\ttime nanoseconds\t%,12.0f", System.nanoTime() - t0));
*/

/*
    int arrayShake[] = array.clone();
    t0 = System.nanoTime();
    Shake.sort(arrayShake);
    System.out.println(String.format("Shake\t\ttime nanoseconds\t%,12.0f", System.nanoTime() - t0));
*/

    int arrayMerge[] = array.clone();
    t0 = System.currentTimeMillis();
    MergeSort.sort(arrayMerge);
    System.out.println(String.format("Merge\t\ttime milliseconds\t%,18.0f", System.currentTimeMillis() - t0));
  }
}