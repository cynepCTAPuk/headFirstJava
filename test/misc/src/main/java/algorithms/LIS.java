package algorithms;

/**
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * https://habr.com/ru/post/343210/
 * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * http://e-maxx.ru/algo/longest_increasing_subseq_log
 *
 * Наибольшая возрастающая подпоследовательность<p>
 * Вход: последовательность A [1. . .n] = [a<sub>1</sub>, a<sub>2</sub>, . . . , a<sub>n</sub>].<p>
 * Выход: наибольшая возрастающая подпоследовательность (НВП),
 * то есть a<sub>i1</sub>, a<sub>i2</sub>, . . . ,a<sub>ik</sub> такие что
 * i<sub>1</sub> < i<sub>2</sub> < . . . < i<sub>k</sub>, a<sub>i1</sub> < a<sub>i2</sub> < · · · < a<sub>ik</sub> и k максимально.
 */
public class LIS {
    public static void main(String[] args) {
        int[] a = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1};
//        int[] a = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        lisBottomUp2(a);
//        lisQuickSearch(a);
    }

    private static int binarySearchOrHigh(int a[], int low, int high, int key) {
        while (low + 1 < high) {
            int mid = (high + low) / 2;
            if (a[mid] >= key)
                high = mid;
            else
                low = mid;
        }
        return high;
    }

    private static void lisQuickSearch(int[] a) {
        int[] d = new int[a.length];
        d[0] = a[0];
        int len = 1;

        for (int value : a) {
            if (value < d[0])
                d[0] = value;
            else if (value > d[len - 1])
                d[len++] = value;
            else {
                d[binarySearchOrHigh(d, -1, len - 1, value)] = value;
            }
        }
        printArray(a);
        printArray(d);
        System.out.println(len);
    }

    private static int lisBottomUp(int[] a) {
        int n = a.length;
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++)
                if (a[j] < a[i] && d[j] + 1 > d[i])
                    d[i] = d[j] + 1;
        }
        printArray(a);
        printArray(d);

        int result = 0;
        for (int i = 0; i < n; i++) result = Math.max(result, d[i]);
        System.out.println(result);
        return result;
    }

    private static int lisBottomUp2(int[] a) {
        int n = a.length;
        int[] d = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) result = Math.max(result, d[i]);
        printArray(a,"исходная последовательность");
        printArray(d,"d");
        printArray(prev,"prev");

        int max = 1;
        for (int i = 1; i < n; i++) if (d[i] > d[max]) max = i;

        int[] idxs = new int[result];
        int[] seq = new int[result];
        int j = result - 1;
        while (max > 0) {
            idxs[j] = max;
            seq[j] = a[idxs[j]];
            j--;
            max = prev[max];
        }
        printArray(idxs, "индексы");
        printArray(seq, "числа");
        System.out.println(result);
//        for (int i = 0; i < result; i++) System.out.printf("%4d", a[idxs[i]]);
//        System.out.println();
        return result;
    }

    private static void printArray(int[] array, String... comment) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.printf("%3d,", array[i]);
            else System.out.printf("%3d]", array[i]);
        }
        if (comment.length == 0) System.out.println();
        else System.out.println(" " + comment[0]);
    }

    private static int longestIncreasingSubsequenceLength(int a[]) {
        // Add boundary case, when array a[] size is one
        int[] tailTable = new int[a.length];
        int len; // always points empty slot

        tailTable[0] = a[0];
        len = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < tailTable[0])
                tailTable[0] = a[i];    // new smallest value
            else if (a[i] > tailTable[len - 1])
                tailTable[len++] = a[i];    // a[i] wants to extend largest subsequence
            else
                // a[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[binarySearchOrHigh(tailTable, -1, len - 1, a[i])] = a[i];
        }
        printArray(a);
        printArray(tailTable);
        return len;
    }
}
