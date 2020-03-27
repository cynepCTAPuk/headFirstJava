package com.javarush.task.task39.task3912;

/*
Максимальная площадь
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1}
        };
        printArray(matrix);
        System.out.println();
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int maxRowLength = 0;
        for (int[] row : matrix) if (row.length > maxRowLength) maxRowLength = row.length;

        int[][] copy = new int[matrix.length][maxRowLength];
        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) copy[i][j] = matrix[i][j];
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix[i].length);
        }
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                } else if (matrix[i][j] > 0) {
                    copy[i][j] = 1 +
                            Math.min(copy[i][j - 1], Math.min(copy[i - 1][j], copy[i - 1][j - 1]));
                }
                if (copy[i][j] > result) result = copy[i][j];
            }
        }
        printArray(copy);
        return result * result;
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int i : row) System.out.print(i + " ");
            System.out.println();
        }
    }
}
