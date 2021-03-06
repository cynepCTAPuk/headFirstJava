import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        lisBottomUp(a);
    }

    private static void lisBottomUp(int[] a) {
        int size = a.length;
        int[] d = new int[size];
        int[] prev = new int[size];
        for (int i = 0; i < size; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++)
                if (a[i] <= a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
        }
        int result = 0;
        for (int i = 0; i < size; i++) {
            result = Math.max(result, d[i]);
        }
        System.out.println(result);

        int[] idxs = new int[result];
        int j = result - 1;
        while (result >= 0) {
            idxs[j] = result + 1;
            j--;
            result = prev[result];
        }
        for (int idx : idxs) {
            System.out.print(idx + " ");
        }
    }
}
