package test;

import java.util.Arrays;

public class SortByMerge {
    public static void sort(Object[] a) {
        Object[] aux = a.clone();
        mergeSort(aux, a, 0, a.length, 0);
    }

    private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
//        a lot of other code here
        for (int i = low; i < high; i++) {
            for (int j = i; j > low &&
                    ((Comparable) dest[j - 1]).compareTo((Comparable) dest[j]) > 0; j++) {
                swap(dest, j, j - 1);
            }
        }
    }

    private static void swap(Object[] dest, int a, int b) {
        Object t = dest[a];
        dest[a] = dest[b];
        dest[b] = t;
    }

    public static void main(String[] args) {
        Object[] list = {1, 4, 2, 3};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
    }
}
