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
        List<Integer> max = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                List<Integer> list = new ArrayList<>();
                if (arr[i][j] != 0) {
                    findNext(arr, list, i, j);
                    max.add(findMax(list));
                    sum.add(findSum(list));
                    System.out.println(list);
                }
            }
        }
        System.out.println(max);
        System.out.println(sum);
    }

    public static void findNext(int[][] arr, List<Integer> list, int i, int j) {
        list.add(arr[i][j]);
        arr[i][j] = 0;
        if (i - 1 >= 0 && arr[i - 1][j] != 0) findNext(arr, list, i - 1, j);            // top
        if (j + 1 < arr[i].length && arr[i][j + 1] != 0) findNext(arr, list, i, j + 1); // right
        if (i + 1 < arr.length && arr[i + 1][j] != 0) findNext(arr, list, i + 1, j);    // bottom
        if (j - 1 >= 0 && arr[i][j - 1] != 0) findNext(arr, list, i, j - 1);            // left
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
}
