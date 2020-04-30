package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinarySearch {
    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/000/input.txt"));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();

        int k = in.nextInt();
        int[] b = new int[k];
        for (int i = 0; i < k; i++) b[i] = in.nextInt();

        for (int i = 0; i < k; i++) {
//            int pos = linearSearch(a, b[i]);
            int pos = binarySearch(a, b[i]);
//            int pos = binarySearchFirst(a, b[i]);
//            int pos = binarySearchLast(a, b[i]);
            System.out.print(pos + " ");
        }
        System.out.println();
    }

    private int binarySearch(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (a[m] == x) return m + 1;
            else if (a[m] > x) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    // Поиск первого элемента из повторяющегося списка элементов
    private int binarySearchFirst(int[] a, int x) {
        int l = -1;
        int r = a.length;
//        a[l] < x;
//        a[r] >= x;
        while (l + 1 < r) {
            int m = (l + r) >> 1;
            if (a[m] < x) l = m;
            else r = m;
        }
        if (r < a.length && a[r] == x) return r + 1;
        else return -1;
    }

    // Поиск последнего элемента из повторяющегося списка элементов
    private int binarySearchLast(int[] a, int x) {
        int l = -1;
        int r = a.length;
//        a[l] <= x;
//        a[r] > x;
        while (l + 1 < r) {
            int m = (l + r) >> 1;
            if (a[m] <= x) l = m;
            else r = m;
        }
        if (l >= 0 && a[l] == x) return l + 1;
        else return -1;
    }

    private int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
