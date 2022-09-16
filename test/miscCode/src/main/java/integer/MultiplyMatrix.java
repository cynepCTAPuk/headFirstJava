package integer;

import java.util.Arrays;

public class MultiplyMatrix {
    public static void main(String[] args) {
        int[][] m1 = {{1, 0}, {1, 0}};
        int[][] m2 = {{0, 1}, {1, 0}};
        printArray(m1);
        printArray(m2);
        printArray(multiply(m1, m2));
    }

    public static int[][] multiply(int[][] m1, int[][] m2) {
        int m = m1.length;
        int n = m2[0].length;
        int o = m2.length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }

    public static void printArray(int[][] m1) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
