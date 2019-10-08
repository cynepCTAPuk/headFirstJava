import java.util.ArrayList;
import java.util.List;

public class Clusters {
    static int[][] arr = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 5, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 7, 2, 8, 0, 0},
            {0, 0, 0, 0, 0, 8, 0, 9, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    public static List<Integer> list = new ArrayList();

    public static void main(String[] args) {
        Clusters clusters = new Clusters();
        clusters.printMatrix();
        List<Integer> max = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    clusters.findNext(i, j);
                    max.add(clusters.findMax(list));
                    sum.add(clusters.findSum(list));
//                    System.out.println(list);
                    list.clear();
                }
            }
        }
        System.out.println(max);
        System.out.println(sum);
    }

    public void findNext(int i, int j) {
        list.add(arr[i][j]);
        arr[i][j] = 0;

        if (j + 1 < arr[i].length && arr[i][j + 1] != 0) findNext(i, j + 1);
        if (i + 1 < arr.length && arr[i + 1][j] != 0) findNext(i + 1, j);
        if (j - 1 >= 0 && arr[i][j - 1] != 0) findNext(i, j - 1);
        if (i - 1 >= 0 && arr[i - 1][j] != 0) findNext(i - 1, j);
    }

    public int findMax(List<Integer> list) {
        int max = 0;
        for (Integer i : list) if (i > max) max = i;
        return max;
    }

    public int findSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) sum += i;
        return sum;
    }

    public void printMatrix() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) System.out.print("  ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
