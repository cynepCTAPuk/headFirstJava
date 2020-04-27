package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Stepik: число инверсий
 * Первая строка содержит число 1≤n≤10<sup>5</sup>, вторая — массив A[1…n],
 * содержащий натуральные числа, не превосходящие 10<sup>9</sup>. Необходимо посчитать число пар
 * индексов 1≤i<j≤n, для которых A[i]>A[j]. (Такая пара элементов называется инверсией массива.
 * Количество инверсий в массиве является в некотором смысле его мерой неупорядоченности:
 * например, в упорядоченном по неубыванию массиве инверсий нет вообще, а в массиве,
 * упорядоченном по убыванию, инверсию образуют каждые два элемента.)<p>
 * Sample Input:<p>
 * 5<p>
 * 2 3 9 2 9<p>
 * Sample Output:<p>
 * 2
 */
public class Test641 {
    static int sum = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c:/000/input.txt"));
        int n = scanner.nextInt();

        int maxN = (int) Math.pow(2, (int) Math.ceil(Math.log(n) / Math.log(2)));
        int[] array = new int[maxN];

        for (int i = maxN - n; i < maxN; i++) {
            array[i] = scanner.nextInt();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < maxN; i++) {
            queue.add(new int[]{array[i]});
        }

        while (queue.size() > 1) queue.add(merge(queue.poll(), queue.poll()));
        System.out.println(sum);
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (idx1 == arr1.length) {
                for (int j = idx2; j < arr2.length; j++) {
                    result[i++] = arr2[j];
                }
            } else if (idx2 == arr2.length) {
                for (int j = idx1; j < arr1.length; j++) {
                    result[i++] = arr1[j];
                }
            } else {
                if (arr1[idx1] <= arr2[idx2]) {
                    result[i] = arr1[idx1++];
                } else {
                    result[i] = arr2[idx2++];
                    sum += arr1.length - idx1;
                }
            }
        }
        return result;
    }
}
