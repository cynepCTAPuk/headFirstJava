import java.util.Arrays;
import java.util.Scanner;

/**
 * Maximum path sum I
 * <p>
 * Problem 18
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 * <p>
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom of the triangle below:
 * <p>
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * <p>
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
 * it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class n018 {
    public static void main(String[] args) {
//        String s = "3\n" + "7 4\n" + "2 4 6\n" + "8 5 9 3";
        String s = "75\n" +
                "95 64\n" +
                "17 47 82\n" +
                "18 35 87 10\n" +
                "20 04 82 47 65\n" +
                "19 01 23 75 03 34\n" +
                "88 02 77 73 07 63 67\n" +
                "99 65 04 28 06 16 70 92\n" +
                "41 41 26 56 83 40 80 70 33\n" +
                "41 48 72 33 47 32 37 16 94 29\n" +
                "53 71 44 65 25 43 91 52 97 51 14\n" +
                "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
        s = s.replace("\n", " ");
        Scanner sc = new Scanner(s);
        int h = 15;
        int[][] array = new int[h][h];
        // fill array
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < i + 1; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < h; i++) System.out.println(Arrays.toString(array[i])); // print array
//        printTriangle(array);
        long t0;
/*
        t0 = System.nanoTime();
        System.out.println(findLargestPath(array, 0, 0));
        System.out.printf("%,10d\n", System.nanoTime() - t0);
*/
        t0 = System.nanoTime();
        System.out.println("Max sum: " + maxPathSum(array));
        System.out.printf("Running time: %,10d\n", System.nanoTime() - t0);

        for (int i = 0; i < h; i++) System.out.println(Arrays.toString(array[i])); // print array
//        printTriangle(array);
        path(array);
    }

    static int findLargestPath(int[][] triangle, int row, int col) {
        // Check to see if the row and column are actually in the triangle
        //If they are not. ensure that this path wont be taken.
        if (col == -1 || col >= triangle[row].length) return -1;
        if (row == triangle.length - 1) {
            return triangle[row][col]; //Return the value.
        } else {
            //return this value plus the maximum path below
            return triangle[row][col] + Math.max(
                    findLargestPath(triangle, row + 1, col),
                    findLargestPath(triangle, row + 1, col + 1));
        }
    }

    static int maxPathSum(int tri[][]) {
        for (int i = tri.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int current = tri[i][j];
                int right = tri[i][j + 1];
                int top = tri[i - 1][j];
// second condition in conditional ensures that we don't add negative numbers, which would only decrease our max sum
                if (current > right && current + top > top) {
                    tri[i - 1][j] += current;
                } else if (current < right && right + top > top) {
                    tri[i - 1][j] += right;
                }
/*
                if (tri[i][j] > tri[i][j + 1] && tri[i][j] + tri[i - 1][j] > tri[i - 1][j]) {
                    tri[i - 1][j] += tri[i][j];
                } else if (tri[i][j] < tri[i][j + 1] && tri[i][j + 1]+tri[i - 1][j] > tri[i - 1][j]){
                    tri[i - 1][j] += tri[i][j + 1];
                }
*/
            }
        }
        return tri[0][0];
    }

    static void path(int[][] array) {
        int n = 0, i = 0, j = 0;
        System.out.print(array[i][j] + " ");
        while (n < array.length - 1) {
            n++;
            if (array[i + 1][j] < array[i + 1][j + 1]) j++;
            i++;
            System.out.print(array[i][j] + " ");
        }
    }

    static int sum(int[][] array, int i, int j) {
        int height = array.length;
        System.out.println(array[i][j]);
        if (i == 0 && j == 0) {
            return array[i][j];
        }
        return array[i][j] + sum(array, i - 1, j - 1);

    }

    static int[][] ways(int height) {
        int[][] array = new int[height][height];
        for (int i = 0; i < height; i++) {
            array[i][0] = 1;
            array[i][i] = 1;
        }
        for (int i = 2; i < height; i++) {
            for (int j = 1; j < i + 1; j++) {
                array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
            }
        }
        printTriangle(array);
        return array;
    }

    private static void printTriangle(int[][] array) {
        int height = array.length;
        for (int i = 0; i < height; i++) {
            int format = 6;
            int spaces = height * (format - 2) - i * 3 - 6;
            for (int k = 0; k < spaces; k++) System.out.print(" "); // сдвиг вправо
            for (int j = 0; j < i + 1; j++) System.out.printf("%,6d", array[i][j]); // печать строк
            System.out.println();
        }
    }
}
