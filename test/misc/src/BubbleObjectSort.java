class BubbleObjectSort implements SortAlgorithm {
  /**
   * @param array The array to be sorted
   *              Sorts the array in increasing order
   **/

  public <T extends Comparable<T>> T[] sort(T array[]) {
    int last = array.length;
    boolean swap;
    int count = 0;
    do {
      swap = false;
      for (int i = 0; i < last - 1; i++) {
        count++;
        if (UtilsSort.less(array[i], array[i + 1])) {
          swap = UtilsSort.swap(array, i, i + 1);
        }
      }
      last--;
    } while (swap);
    System.out.println(String.format("BubbleS\tcycles\t%,d", count));
    return array;
  }
}
