import java.util.Arrays;

/**
 * Lattice paths
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * 1)      2)     3)     4)    5)     6)
 * ->->   ->     ->     |      |      |
 * |    |->    |     ->->   ->     |
 * |      |    |->      |    |->   ->->
 * How many such routes are there through a 20×20 grid?
 */
public class n015 {
    public static void main(String[] args) {
        int n = 21;
        long[][] array = new long[n][n];
        for (int i = 0; i < n; i++) {
            array[0][i] = 1L;
            array[i][0] = 1L;
        }
        for (int i = 0; i < n; i++) System.out.println(Arrays.toString(array[i]));
        System.out.println(f(array, n));
        for (int i = 0; i < n; i++) System.out.println(Arrays.toString(array[i]));
    }

    static long f(long[][] array, int n) {
        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j++)
                array[i][j] = array[i - 1][j] + array[i][j - 1];
        return array[n - 1][n - 1];
    }
}
