package algorithms.stepik1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Stepic: рюкзак<p>
 * Первая строка входа содержит целые числа 1 ≤ W ≤ 10<sup>4</sup> и 1 ≤ n ≤ 300 — вместимость
 * рюкзака и число золотых слитков. Следующая строка содержит n целых
 * чисел 0 ≤ w<sub>1</sub>, …, w<sub>n</sub> ≤ 10<sup>5</sup>, задающих веса слитков.
 * Найдите максимальный вес золота, который можно унести в рюкзаке.<p>
 * Sample Input:<p>
 * 10 3<p>
 * 1 4 8<p>
 * Sample Output:<p>
 * 9
 */
public class Test841 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        int size = scanner.nextInt();
        int[] n = new int[size];
        for (int i = 0; i < size; i++) {
            n[i] = scanner.nextInt();
        }
        System.out.println(knapsackWithoutRepsBU(weight, n));
    }

    private static int knapsackWithoutRepsBU(int weight, int[] n) {
        int[][] result = new int[n.length + 1][weight + 1];

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = result[i - 1][j];
                if (n[i - 1] <= j) {
                    result[i][j] = Math.max(result[i][j], result[i - 1][j - n[i - 1]] + n[i - 1]);
                }
            }
        }
        return result[n.length][weight];
    }
}