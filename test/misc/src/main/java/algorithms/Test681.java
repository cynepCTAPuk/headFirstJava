package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Stepik: сортировка подсчётом
 * Первая строка содержит число 1 ≤ n ≤ 10<sup>4</sup>, вторая — n натуральных чисел, не превышающих 10.
 * Выведите упорядоченную по неубыванию последовательность этих чисел.<p>
 * Sample Input:<p>
 * 5<p>
 * 2 3 9 2 9<p>
 * Sample Output:<p>
 * 2 2 3 9 9
 */
public class Test681 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c:/000/input.txt"));
        int n = scanner.nextInt();
        int[] A = new int[n];
        int k = 10;
        int[] B = new int[k];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            B[A[i]]++;
        }
        printArray(A);

        for (int i = 1; i < k; i++) {
            B[i] += B[i - 1];
        }

        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[B[A[i]] - 1] = A[i];
            B[A[i]]--;
        }
        printArray(result);
    }

    static void printArray(int[] array) {
        System.out.print("[");
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (i < size - 1) System.out.print(array[i] + ", ");
            else System.out.println(array[i] + "]");
        }
    }

}
