package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Stepic: точки и отрезки
 * В первой строке задано два целых числа 1 ≤ n ≤ 50000 и 1 ≤ m ≤ 50000 — количество отрезков и
 * точек на прямой, соответственно. Следующие n строк содержат по два целых
 * числа a<sub>i</sub> и b<sub>i</sub> (a<sub>i</sub> ≤ b<sub>i</sub>) — координаты концов отрезков.
 * Последняя строка содержит m целых чисел — координаты точек. Все координаты
 * не превышают 10<sup>8</sup> по модулю. Точка считается принадлежащей отрезку, если она
 * находится внутри него или на границе. Для каждой точки в порядке появления во вводе
 * выведите, скольким отрезкам она принадлежит.<p>
 * Sample Input:<p>
 * 2 3<p>
 * 0 5<p>
 * 7 10<p>
 * 1 6 11<p>
 * Sample Output:<p>
 * 1 0 0
 */
public class Test651naive {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c:/000/input.txt"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] begins = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            begins[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        int[] dots = new int[m];
        for (int i = 0; i < m; i++) dots[i] = scanner.nextInt();

        printArray(begins);
        printArray(ends);
        printArray(dots);

        for (int i = 0; i < m; i++) {
            int qty = 0;
            for (int j = 0; j < n; j++)
                if (begins[j] <= dots[i] && dots[i] <= ends[j])
                    qty++;
            System.out.print(qty + " ");
        }
    }

    static void printArray(int[] array) {
        System.out.print("[");
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (i < size - 1) System.out.print(array[i] + " ");
            else System.out.println(array[i] + "]");
        }
    }
}
