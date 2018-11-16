package utils;

class Shake1 {
  static void sort(int[] array) {
    int s = array.length;
    int left = 0;
    int right = array.length - 1;
    int swap, swappedLeft, swappedRight;
    long count = 0;
    while (left < right) {
      swappedRight = 0;
      for (int i = left; i < right; i++) {
        count++;
        if ((count % (s*s>>5)) == 0) System.out.print("X");
        if (array[i] > array[i + 1]) {
          swap = array[i];
          array[i] = array[i + 1];
          array[i + 1] = swap;
          swappedRight = i;
        }
      }
      right = swappedRight;
      swappedLeft = array.length - 1;
      for (int i = right; i > left; i--) {
        count++;
        if ((count % (s*s>>5)) == 0) System.out.print("X");
        if (array[i - 1] > array[i]) {
          swap = array[i - 1];
          array[i - 1] = array[i];
          array[i] = swap;
          swappedLeft = i;
        }
      }
      left = swappedLeft;
    }
    System.out.println();
    System.out.println(String.format("Shake1\tcycles\t%,d", count));
  }
}
