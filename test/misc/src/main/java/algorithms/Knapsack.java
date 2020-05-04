package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Stepik: Задача о рюкзаке (8.4)<p>
 * Вход: веса w<sub>1</sub>, ..., w<sub>n</sub> N и стоимости c<sub>1</sub>, ..., c<sub>n</sub> N
 * данных n предметов; вместимость рюкзака W<p>
 * Выход: максимальная стоимость предметов суммарного веса не более W<p>
 * Варианты:<p>
 * Рюкзак с повторениями: неограниченное количество каждого из предметов.<p>
 * Рюкзак без повторений: единственный экземпляр каждого предмета.<p>
 */
public class Knapsack {
    public static void main(String[] args) throws FileNotFoundException {
        int weight = 10;
        int[] n = {6, 3, 4, 2};
        int[] c = {30, 14, 16, 9};

        int[] d = knapsackWithRepsBU(weight, n, c);
        printArray(d);
    }

    private static int[] knapsackWithRepsBU(int weight, int[] n, int[] c) {
        int[] d = new int[weight + 1];
        for (int w = 1; w < d.length; w++) {
            for (int i = 0; i < n.length; i++) {
                if (n[i] <= w) {
                    d[w] = Math.max(d[w], d[w - n[i]] + c[i]);
                }
            }
        }
        return d;
    }

    private static void print2dArray(int[][] array) {
        for (int[] rows : array) {
            for (int element : rows) System.out.printf("%3d", element);
            System.out.println();
        }
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