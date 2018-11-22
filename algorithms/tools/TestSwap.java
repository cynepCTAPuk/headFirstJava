package tools;

public class TestSwap {
  public static void main(String[] args) {
    Integer[] integers = {5, 12, 3, 7, 2};
    String[] strings = {"one", "two", "three", "four"};

    Utils.printForEach(integers);
    swap(integers, 0, 1);
    Utils.printForEach(integers);

    Utils.printForEach(strings);
    swap(strings, 0, 1);
    Utils.printForEach(strings);
  }

  public static <T> void swap(T[] array, int left, int right) {
    T temp = array[right];
    array[right] = array[left];
    array[left] = temp;
  }
}
