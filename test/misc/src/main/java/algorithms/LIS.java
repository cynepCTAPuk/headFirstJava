package algorithms;

/**
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
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
//        System.out.println(lisBottomUp2(a));
        System.out.println(
//                "Length of Longest Increasing Subsequence is " +
                        longestIncreasingSubsequenceLength(a));
    }

    private static int lisBottomUp(int[] a) {
        int n = a.length;
        int[] d = new int[n];

        for (int j = 0; j < n; j++) {
            d[j] = 1;
            for (int i = 0; i < j; i++)
                if (a[i] < a[j] && d[i] + 1 > d[j])
                    d[j] = d[i] + 1;
        }
        printArray(a);
        printArray(d);

        int result = 0;
        for (int i = 0; i < n; i++) result = Math.max(result, d[i]);
        return result;
    }

    private static int lisBottomUp2(int[] a) {
        int n = a.length;
        int[] d = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++)
                if (a[j] < a[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
        }

        int result = 0;
        for (int i = 0; i < n; i++) result = Math.max(result, d[i]);
        printArray(a);
        printArray(d);
        printArray(prev);

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
        printArray(idxs);
        printArray(seq);
//        for (int i = 0; i < result; i++) System.out.printf("%4d", a[idxs[i]]);
//        System.out.println();
        return result;
    }

    static int ceilIndex(int a[], int left, int right, int key) {
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (a[middle] >= key)
                right = middle;
            else
                left = middle;
        }
        return right;
    }

    private static int longestIncreasingSubsequenceLength(int a[]) {
        // Add boundary case, when array size is one
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
                tailTable[ceilIndex(tailTable, -1, len - 1, a[i])] = a[i];
        }
        printArray(a);
        printArray(tailTable);
        return len;
    }


    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.printf("%3d,", array[i]);
            else System.out.printf("%3d]%n", array[i]);
        }
    }
}
