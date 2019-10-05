public class TestSort {
  public static void main(String[] args) {
    double t0;
    int nElements = 100_000;
    int[] array = new int[nElements];
//    for (int i = 0; i < nElements; i++) array[i] = i; // Sorted array
//    for (int i = 0; i < nElements; i++) array[nElements - 1 - i] = i; //Reversed sorted array
    Utils.fillRandom100(array);
    System.out.println(String.format("Кол-во элементов = %,d", nElements));
    int arrayBubble[] = array.clone();
    int arrayInsert[] = array.clone();
    int arrayOddEven[] = array.clone();
    int arraySelection[] = array.clone();
    int arrayShake[] = array.clone();

    t0 = System.nanoTime();
//    Bubble.sort(arrayBubble);
    double tBubble = System.nanoTime() - t0;

    t0 = System.nanoTime();
    Insertion.sort(arrayInsert);
    double tInsertion = System.nanoTime() - t0;

    t0 = System.nanoTime();
//    OddEven.sort(arrayOddEven);
    double tOddEven = System.nanoTime() - t0;

    t0 = System.nanoTime();
//    Selection.sort(arraySelection);
    double tSelection = System.nanoTime() - t0;

    t0 = System.nanoTime();
//    Shake.sort(arrayShake);
    double tShake = System.nanoTime() - t0;

//    for (int i = 0; i < 50; i++) System.out.print(array[i] + " ");
//    System.out.println();
//    for (int i = 0; i < 50; i++) System.out.print(arrayBubble[i] + " ");
//    System.out.println();

//    System.out.println(String.format("Bubble\t\ttime nanoseconds\t%,.0f", tBubble));
    System.out.println(String.format("Insertion\ttime nanoseconds\t%,.0f", tInsertion));
//    System.out.println(String.format("OddEven\t\ttime nanoseconds\t%,.0f", tOddEven));
//    System.out.println(String.format("Selection\ttime nanoseconds\t%,.0f", tSelection));
//    System.out.println(String.format("Shake\t\ttime nanoseconds\t%,.0f", tShake));
  }
}