package algorithms;

public class MatrixMultiply {
    public static void main(String[] args) {
        int[][] a = {
                {33, 34, 12},
                {33, 19, 10},
                {12, 14, 17},
                {84, 24, 51},
                {43, 71, 21}};

        int[][] b = {
                {10, 11, 34, 55},
                {33, 45, 17, 81},
                {45, 63, 12, 16}};

        int[][] res = getMultiplyMatrix(a, b);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                System.out.format("%,6d ", res[i][j]);
            System.out.println();
        }
    }

    private static int[][] getMultiplyMatrix(int[][] a, int[][] b) {
        int m = a.length;       // a rows
        int n = a[0].length;    // a columns
        int p = b.length;       // b rows
        int s = b[0].length;    // b columns
        if (n != p) {
            System.out.println("These matrices can't be multiplied");
            return new int[0][0];
        }

        int[][] result = new int[m][s];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < s; j++)
                for (int k = 0; k < p; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }
}