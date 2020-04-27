package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Stepik: двоичный поиск
 * В первой строке даны целое число 1≤n≤10<sup>5</sup> и массив A[1…n] из n различных натуральных чисел,
 * не превышающих 10<sup>9</sup>, в порядке возрастания, во второй — целое число 1≤k≤10<sup>5</sup> и
 * k натуральных чисел b<sub>1</sub>,…,b<sub>k</sub>, не превышающих 10<sup>9</sup>.
 * Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n, для которого A[j]=b<sub>i</sub>,
 * или −1, если такого j нет.<p>
 * Sample Input:<p>
 * 5 1 5 8 12 13<p>
 * 5 8 1 23 1 11<p>
 * Sample Output:<p>
 * 3 1 -1 1 -1
 */
public class Test611 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c:/000/input.txt"));

        int n = scanner.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) arrN[i] = scanner.nextInt();

        int k = scanner.nextInt();
        int[] arrK = new int[k];
        for (int i = 0; i < k; i++) arrK[i] = scanner.nextInt();

        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = find(arrK[i], arrN);
        printArray(result);
    }

    static int find(int k, int[] array) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int value = array[m];
            if (value == k) return m + 1;
            else if (value > k) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.print(array[i] + " ");
            else System.out.println(array[i]);
        }
    }
}
