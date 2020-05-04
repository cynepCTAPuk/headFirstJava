package algorithms;

/**
 * Stepic: наибольшая последовательнократная подпоследовательность
 * Дано целое число 1 ≤ n ≤ 10<sup>3</sup> и массив A[1…n] натуральных чисел,
 * не превосходящих 2⋅10<sup>9</sup>. Выведите максимальное 1 ≤ k ≤ n, для которого
 * найдётся подпоследовательность 1 ≤ i<sub>1</sub> < i<sub>2</sub> < … < i<sub>k</sub> ≤ n
 * длины k, в которой каждый элемент делится на предыдущий (формально: для  всех
 * 1 ≤ j < k, A[i<sub>j</sub>] A[i<sub>j+1</sub>]).<p>
 * Sample Input:<p>
 * 4<p>
 * 3 6 7 12<p>
 * Sample Output:<p>
 * 3
 */
public class Test821 {
    public static void main(String[] args) {
        int[] a = {3, 6, 7, 6};
        System.out.println(lisBottomUp(a));
    }

    private static int lisBottomUp(int[] a) {
        int size = a.length;
        int[] d = new int[size];

        for (int i = 0; i < size; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++)
                if (a[i] >= a[j] && d[i] < d[j] + 1 && a[i] % a[j] == 0)
                    d[i] = d[j] + 1;
        }
        printArray(a);
        printArray(d);

        int result = 0;
        for (int i = 0; i < size; i++) result = Math.max(result, d[i]);
        return result;
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.printf("%3d,", array[i]);
            else System.out.printf("%3d]%n", array[i]);
        }
    }
}
