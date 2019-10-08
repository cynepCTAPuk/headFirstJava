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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) System.out.print("  ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        List<Point> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    System.out.println(
                            "(" + i + ", " + j + ") = " + (i * i + j * j) + " - " + arr[i][j]);
                    list.add(new Point(i, j, arr[i][j]));
                }
            }
        }
        System.out.println(list);

        ArrayList maxValues = new ArrayList();
        ArrayList sums = new ArrayList();
        int max = list.get(0).getValue();
        int sum = list.get(0).getValue();

        for (int i = 1; i < list.size(); i++) {
        }

        System.out.println(maxValues);
        System.out.println(sums);
    }

}

