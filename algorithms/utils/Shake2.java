package utils;

class Shake2 {
  static void sort(int[] array) {
    int s = array.length;
    int left = 0;
    int right = array.length - 1;
    int swappedLeft, swappedRight;
    long count = 0;
    while (left < right) {
      swappedRight = 0;
      for (int i = left; i < right; i++) {
        count++;
        if ((count % (s*s>>5)) == 0) System.out.print("X");
        if (array[i] > array[i + 1]) {
          Utils.swap(array, i, i + 1);
          swappedRight = i;
        }
      }
      right = swappedRight;
      swappedLeft = array.length - 1;
      for (int i = right; i > left; i--) {
        count++;
        if ((count % (s*s>>5)) == 0) System.out.print("X");
        if (array[i - 1] > array[i]) {
          Utils.swap(array, i - 1, i);
          swappedLeft = i;
        }
      }
      left = swappedLeft;
    }
    System.out.println();
    System.out.println(String.format("Shake2\tcycles\t%,d", count));
  }
}
