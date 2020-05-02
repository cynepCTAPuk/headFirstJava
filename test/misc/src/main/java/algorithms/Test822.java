package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Test822 {
    public static void main(String[] args) {
        int[] a = {5, 3, 4, 4, 2};
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
        printArray(a);
        printArray(d);
        printArray(prev);
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
        printArray(idxs);

    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.printf("%3d,", array[i]);
            else System.out.printf("%3d]%n", array[i]);
        }
    }
}
