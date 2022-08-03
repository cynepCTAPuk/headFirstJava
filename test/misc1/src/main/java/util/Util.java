package util;

public class Util {
    public static void printArray(int[] array, String... comment) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.printf("%3d,", array[i]);
            else System.out.printf("%3d]", array[i]);
        }
        if (comment.length == 0) System.out.println();
        else System.out.println(" " + comment[0]);
    }

    public static void print2dArray(int[][] array) {
        for (int[] rows : array) {
            for (int element : rows) System.out.printf("%10d", element);
            System.out.println();
        }
    }

}
