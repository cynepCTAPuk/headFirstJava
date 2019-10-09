package Test;

import java.util.ArrayList;
import java.util.List;

public class Clusters1 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 2, 3, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 1, 0, 0, 0},
                {0, 3, 5, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 7, 2, 8, 0, 0},
                {0, 0, 0, 0, 0, 8, 0, 9, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        printMatrix(arr);
        List<Integer> max = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();

        List<Point> list = createList(arr);
        System.out.println(list);
   }

    private static List<Point> createList(int[][] arr) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    list.add(new Point(i, j, arr[i][j]));
                }
            }
        }
        return list;
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