package utils;

import java.util.Arrays;

class Shake2 {
  static void sort(int[] array) {
    int left = 0;
    int right = array.length - 1;
    int swappedLeft, swappedRight;
    long count = 0;
    while (left < right) {
      swappedRight = 0;
      for (int i = left; i < right; i++) {
        count++;
        if (array[i] > array[i + 1]) {
          UtilsAlgorithms.swap(array, i + 0, i + 1);
          swappedRight = i;
        }
      }
      right = swappedRight;
      swappedLeft = array.length - 1;
      for (int i = right; i > left; i--) {
        count++;
        if (array[i - 1] > array[i]) {
          UtilsAlgorithms.swap(array, i - 1, i);
          swappedLeft = i;
        }
      }
      left = swappedLeft;
    }
//    System.out.println(String.format("utils.Shake1\tcycles\t%,d", count));
  }

  public static void main(String[] args) {
    int[] array = new int[1_000];
    UtilsAlgorithms.fillRandom(array);

    System.out.println(Arrays.toString(array));
    Shake2.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
