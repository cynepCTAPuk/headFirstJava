package clusters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClustersFP {

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
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                points.add(new Point(i, j, arr[i][j]));
        System.out.println(points);
        System.out.println(points.size());

        List<Point> pointList = points.stream()
                .filter((e) -> e.getValue() != 0)
                .collect(Collectors.toList());
        System.out.println(pointList);
        System.out.println(pointList.size());

//        printArr(arr);
    }

    private static void printArr(int[][] arr) {
        System.out.println(Arrays.toString(
                Arrays.stream(arr)
                        .flatMapToInt(Arrays::stream)
                        .toArray()));
    }
}
