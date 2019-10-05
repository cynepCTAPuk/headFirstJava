import java.util.Random;

public class Utils {
  public static void fillRandom100(int[] array) {
    Random rnd = new Random();
    for (int i = 0; i < array.length; i++) array[i] = rnd.nextInt(100);
  }

  static String repeat(String str, int times) {
    return new String(new char[times]).replace("\0", str);
  }

  public static void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  public static <T> void swap(T[] array, int left, int right) {
    T temp = array[right];
    array[right] = array[left];
    array[left] = temp;
  }

  public static void print(int[] array) {
    System.out.print("[");
    int size = array.length;
    for (int i = 0; i < size; i++) {
      if (i == size - 1) System.out.print(array[i] + "]\n");
      else System.out.print(array[i] + ", ");
    }
  }

  public static void printV(int[] one, int[] two) {
    System.out.println("<-|\t|->");
    if (one.length == two.length) {
      for (int i = 0; i < one.length; i++) System.out.println(one[i] + "\t" + two[i]);
    } else System.out.println("Length of arrays must be equal!");
  }

  public static void printForEach(int... array) {
    System.out.print("[");
    for (int i : array) System.out.print(i + " ");
    System.out.println("]");
  }

  public static <T> void printForEach(T... array) {
    System.out.print("[");
    for (T element : array) System.out.print(element + " ");
    System.out.println("]");
  }

  public static void main(String[] args) {
    System.out.println(repeat("*", 10));
  }
}

