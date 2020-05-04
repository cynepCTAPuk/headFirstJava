package algorithms;

/**
 * Stepic: наибольшая невозрастающая подпоследовательность
 * Дано целое число 1 ≤ n ≤ 10<sup>5</sup> и массив A[1…n], содержащий неотрицательные
 * целые числа, не превосходящие 10<sup>9</sup>. Найдите наибольшую невозрастающую
 * подпоследовательность в A. В первой строке выведите её длину k, во второй — её
 * индексы 1 ≤ i<sub>1</sub> < i<sub>2</sub> < … < i<sub>k</sub> ≤ n
 * (таким образом, A[i<sub>1</sub>] ≥ A[i<sub>2</sub>] ≥ … ≥ A[i<sub>n</sub>]).<p>
 * Sample Input:<p>
 * 5<p>
 * 5 3 4 4 2<p>
 * Sample Output:<p>
 * 4<p>
 * 1 3 4 5
 */
public class Test822 {
    public static void main(String[] args) {
        int[] a = {5, 3, 4, 4, 2};
//        int[] a = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1};
//        lisQuickSearch(a);
        lisBottomUp2(a);
    }

    private static int lisBottomUp2(int[] a) {
        int n = a.length;
        int[] d = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = i; j >= 0; j--) {
                if (a[j] >= a[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) result = Math.max(result, d[i]);
        printArray(a, "исходная последовательность");
        printArray(d, "d");
        printArray(prev, "prev");

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

    private static void lisQuickSearch(int[] a) {
        int[] d = new int[a.length];
        int[] prev = new int[a.length];
        d[0] = a[0];
        int len = 1;
        for (int i = 0; i < a.length; i++) {
            prev[i] = -1;
            if (a[i] > d[0])
                d[0] = a[i];
            else if (a[i] <= d[len - 1]) {
                d[len++] = a[i];
                prev[i] = i;
            } else {
                d[binarySearchOrHigh(d, 0, len, a[i])] = a[i];
            }
        }
/*
        for (int i = 0; i < a.length; i++) {
            int m = a[i];
            int n = d[0];
            int j = binarySearchOrHigh(d, 0, len, m);
            if (d[j - 1] < a[i] && a[i] < d[j]) {
                d[j] = a[i];
                len++;
            }
        }
*/
        printArray(a, "a");
        printArray(d, "d");
        printArray(prev, "prev");
        System.out.println(len);
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

    private static void printArray(int[] array, String... comment) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.printf("%3d,", array[i]);
            else System.out.printf("%3d]", array[i]);
        }
        if (comment.length == 0) System.out.println();
        else System.out.println(" " + comment[0]);
    }
}
