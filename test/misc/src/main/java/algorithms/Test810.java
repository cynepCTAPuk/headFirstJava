package algorithms;

/**
 * Динамическое программирование
 * Числа Фибоначчи
 */
public class Test810 {
    public static void main(String[] args) {
        int n1 = 45;
        int n2 = 47; // 47 last int
        long start;
/*
        start = System.nanoTime();
        for (int i = n1; i < n2; i++) System.out.printf("%,d ", fibRecursive(i));
        System.out.printf("%n%,16d%n", System.nanoTime() - start);
*/
/*
        start = System.nanoTime();
        for (int i = n1; i < n2; i++) System.out.printf("%,d ", fibArray(i));
        System.out.printf("%n%,16d%n", System.nanoTime() - start);
*/
/*
        start = System.nanoTime();
        for (int i = n1; i < n2; i++) {
            int[] f = new int[i + 1];
            Arrays.fill(f, -1);
            System.out.printf("%,d ", fibTD(i, f));
        }
        System.out.printf("%n%,16d%n", System.nanoTime() - start);
*/
/*
        start = System.nanoTime();
        for (int i = n1; i < n2; i++) System.out.printf("%,d ", fibBU(i));
        System.out.printf("%n%,16d%n", System.nanoTime() - start);
*/
        start = System.nanoTime();
        for (int i = n1; i < n2; i++) System.out.printf("%,d ", fibBuImproved(i));
//        System.out.printf("%,d ", fibBuImproved(22));
        System.out.printf("%n%,16d ns%n", System.nanoTime() - start);

        start = System.nanoTime();
        for (int i = n1; i < n2; i++) System.out.printf("%,d ", fibMatrix(i));
//        System.out.println(fibMatrix(22));
        System.out.printf("%n%,16d ns%n", System.nanoTime() - start);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.printf("%,8d", matrix[i][j]);
            System.out.println();
        }
    }

    private static int fibRecursive(int n) {
        if (n <= 1) return n;
        else return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    private static int fibArray(int n) {
        int sum[] = new int[]{0, 1};
        for (int i = 0; i < n; i++)
            sum[i & 1] = sum[0] + sum[1];
        return sum[n & 1];
    }

    private static int fibTD(int n, int[] f) {
        if (f[n] == -1) {
            if (n <= 1) f[n] = n;
            else f[n] = fibTD(n - 1, f) + fibTD(n - 2, f);
        }
        return f[n];
    }

    private static int fibBU(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        if (n >= 1) f[1] = 1;
        for (int i = 2; i < n + 1; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }

    private static int fibBuImproved(int n) {
        if (n <= 1) return n;
        int prev = 0;
        int curr = 1;
        for (int i = 0; i < n - 1; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    private static int fibMatrix(int n) {
        if(n<=1) return n;
        int[][] a = {{1, 1}, {1, 0}};
        int[][] b = {{1, 1}, {0, 0}};
        for (int i = 2; i < n; i++) b = getMultiplyMatrix(b, a);
        return b[0][0];
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
