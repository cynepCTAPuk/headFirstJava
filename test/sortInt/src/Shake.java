import java.util.Arrays;

public class Shake {
  public static void sort(int[] array) {
    int left = 0, right = array.length - 1;
    int swappedLeft, swappedRight;

    while (left < right) {
      swappedRight = 0;
      for (int i = left; i < right; i++) {
        if (array[i] > array[i + 1]) {
          int swap = array[i];
          array[i] = array[i + 1];
          array[i + 1] = swap;
          swappedRight = i;
        }
      }
      right = swappedRight;
      swappedLeft = array.length - 1;
      for (int i = right; i > left; i--) {
        if (array[i - 1] > array[i]) {
          int swap = array[i - 1];
          array[i - 1] = array[i];
          array[i] = swap;
          swappedLeft = i;
        }
      }
      left = swappedLeft;
    }
  }
  public static void main(String[] args) {
    int[] array = new int[50];
    Utils.fillRandom100(array);
    System.out.println(Arrays.toString(array));
    OddEven.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
