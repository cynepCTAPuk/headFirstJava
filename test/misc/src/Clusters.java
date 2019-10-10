import java.util.ArrayList;
import java.util.List;

public class Clusters {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 2, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 5, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 7, 2, 8, 0, 0},
                {0, 0, 0, 0, 0, 8, 0, 9, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        printMatrix(arr);
        boolean[][] bit = new boolean[arr.length][arr[0].length];
        printBit(bit);
        List<Integer> max = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!bit[i][j] && arr[i][j] != 0) {
                    List<Integer> list = new ArrayList<>();
                    findNext(arr, bit, list, i, j);
                    max.add(findMax(list));
                    sum.add(findSum(list));
                    System.out.println(list);
                }
            }
        }
        System.out.println(max);
        System.out.println(sum);
        printMatrix(arr);
        printBit(bit);
    }

    public static void findNext(int[][] arr, boolean[][] b, List<Integer> list, int i, int j) {
        list.add(arr[i][j]);
        b[i][j] = true;
        if (i - 1 >= 0 && !b[i - 1][j] && arr[i - 1][j] != 0)
            findNext(arr, b, list, i - 1, j);            // top
        if (j + 1 < arr[i].length && !b[i][j + 1] && arr[i][j + 1] != 0)
            findNext(arr, b, list, i, j + 1); // right
        if (i + 1 < arr.length && !b[i + 1][j] && arr[i + 1][j] != 0)
            findNext(arr, b, list, i + 1, j);    // bottom
        if (j - 1 >= 0 && !b[i][j - 1] && arr[i][j - 1] != 0)
            findNext(arr, b, list, i, j - 1);            // left
    }

    public static int findMax(List<Integer> list) {
        int max = 0;
        for (Integer i : list) if (i > max) max = i;
        return max;
    }

    public static int findSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) sum += i;
        return sum;
    }

    public static void printMatrix(int[][] arr) {
        for (int[] rows : arr) {
            for (int v : rows) {
                if (v == 0) System.out.print("  ");
                else System.out.print(v + " ");
            }
            System.out.println();
        }
    }
    public static void printBit(boolean[][] arr) {
        for (boolean[] rows : arr) {
            for (boolean v : rows) {
                if (v == true) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
