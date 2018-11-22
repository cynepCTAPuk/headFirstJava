package sortInt;

public class Binary {
  public static int search(int[] array, int key) {
    int left = 0;
    int right = array.length - 1;
    int count = 0;
    int median = (left + right) >>> 1;
    while (left <= right) {
      System.out.println("Number of cycle = " + ++count + "\tMiddle of array = " + median);
      if (array[median] == key) return median;
      if (array[median] > key) {
        right = median - 1;
        median = (left + right) >>> 1;
      }
      if (array[median] < key) {
        left = median + 1;
        median = (left + right) >>> 1;
      }
    }
    return -1;
  }
}
