package test;
import java.util.Arrays;
import java.util.Comparator;

public class SortByMerge {
    private static final int INSERTIONSORT_THRESHOLD = 7;
    public static void sort(Object[] a) {
        Object[] aux = a.clone();
        mergeSort(aux, a, 0, a.length, 0);
    }
    private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length < INSERTIONSORT_THRESHOLD) {
            for (int i = low; i < high; i++)
                for (int j = i; j > low &&
                        ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
                    swap(dest, j, j - 1);
            return;
        }

        // Recursively sort halves of dest into src
        int destLow = low;
        int destHigh = high;
        low += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off);
        mergeSort(dest, src, mid, high, -off);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0)
                dest[i] = src[p++];
            else
                dest[i] = src[q++];
        }
    }
    private static void swap(Object[] dest, int a, int b) {
        Object t = dest[a];
        dest[a] = dest[b];
        dest[b] = t;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 4, 2, 3};
        String[] strings = {"a", "d", "b", "c"};

        System.out.println(Arrays.toString(strings));
        sort(strings);
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, Comparator.reverseOrder());
        System.out.println(Arrays.toString(strings));
    }
}
