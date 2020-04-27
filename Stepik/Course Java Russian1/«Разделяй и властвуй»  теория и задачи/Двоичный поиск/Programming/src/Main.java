import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] arrN = new int[n];
    for (int i = 0; i < n; i++) arrN[i] = scanner.nextInt();

    int k = scanner.nextInt();
    int[] arrK = new int[k];
    for (int i = 0; i < k; i++) arrK[i] = scanner.nextInt();

    int[] result = new int[k];
    for (int i = 0; i < k; i++) result[i] = find(arrK[i], arrN);
    printArray(result);
  }

  static int find(int k, int[] array) {
    int l = 0;
    int r = array.length - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      int value = array[m];
      if (value == k) return m + 1;
      else if (value > k) r = m - 1;
      else l = m + 1;
    }
    return -1;
  }

  static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i < array.length - 1) System.out.print(array[i] + " ");
      else System.out.println(array[i]);
    }
  }
}
