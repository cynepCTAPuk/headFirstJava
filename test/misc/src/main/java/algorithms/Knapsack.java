package algorithms;

import util.Util;

import java.io.FileNotFoundException;

/**
 * Stepik Algorithm1: Задача о рюкзаке (8.4)<p>
 * Вход: веса w<sub>1</sub>, ..., w<sub>n</sub> N и стоимости c<sub>1</sub>, ..., c<sub>n</sub> N
 * данных n предметов; вместимость рюкзака W<p>
 * Выход: максимальная стоимость предметов суммарного веса не более W<p>
 * Варианты:<p>
 * Рюкзак с повторениями: неограниченное количество каждого из предметов.<p>
 * Рюкзак без повторений: единственный экземпляр каждого предмета.<p>
 */
public class Knapsack {
    public static void main(String[] args) throws FileNotFoundException {
/*
        int weight = 10;
        int[] n = {6, 3, 4, 2};
        int[] c = {30, 14, 16, 9};
*/
        int weight = 10;
        int[] n = {1, 4, 8};
        int[] c = {1, 4, 8};

/*
        int[] d = knapsackWithRepsBU(weight, n, c);
        Util.printArray(d);
*/
        int[][] d = knapsackWithoutRepsBU(weight, n, c);
        Util.print2dArray(d);
    }

    private static int[][] knapsackWithoutRepsBU(int weight, int[] n, int[] c) {
        int[][] result = new int[n.length + 1][weight + 1];

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = result[i - 1][j];
                if (n[i - 1] <= j) {
                    result[i][j] = Math.max(result[i][j], result[i - 1][j - n[i - 1]] + c[i - 1]);
//                    System.out.println(i + ":" + j);
//                    Util.print2dArray(result);
                }
            }
        }
        return result;
    }

    private static int[] knapsackWithRepsBU(int weight, int[] n, int[] c) {
        int[] result = new int[weight + 1];

        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (n[j] <= i) {
                    result[i] = Math.max(result[i], result[i - n[j]] + c[j]);
//                    Util.printArray(result);
                }
            }
        }
        return result;
    }

}