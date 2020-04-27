package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
public class MergeSortNoRecursion {
    static int sum = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c:/000/input.txt"));
        int n = scanner.nextInt();

        int exp = (int) Math.ceil((Math.log(n) / Math.log(2)));
        int maxN = (int) Math.pow(2, exp);
        int[] array = new int[maxN];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = maxN - n; i < maxN; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < maxN; i++) {
            queue.add(new int[]{array[i]});
        }

//        printArray(array);
//        System.out.println(array.length);

/*
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (array[i] > array[j]) sum++;
*/
        while (queue.size() > 1) queue.add(merge(queue.poll(), queue.poll()));
        System.out.println(sum);

//        printArray(array);
//        printArray(queue.peek());
//        System.out.println(sum1);
//        System.out.println(sum2);
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++)
            if (i < array.length - 1) System.out.print(array[i] + ", ");
            else System.out.println(array[i] + "]");
    }

    static int[] merge(int[] arr1, int[] arr2) {
//        sum1 = 0;
//        sum2 = 0;
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
                    sum += arr1.length - idx1;
                    result[i] = arr2[idx2++];
                }
            }
        }
//        printArray(arr1);
//        printArray(arr2);
        System.out.print(sum + " --- ");
        printArray(result);
        return result;
    }
}
