package chap16_arrays;

import java.util.*;

public class Exercise4 {
    static double[][][] threeDimArray(int size1, int size2, int size3, double start, double end) {
        Random random = new Random();
        double[][][] result = new double[size1][size2][size3];

        if (start > end) {
            System.out.println("May be you need to change limits for array");
            return result;
        }

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                for (int k = 0; k <size3 ; k++) {
                    result[i][j][k] = random.nextDouble() * (end - start) + start;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeDimArray(3, 3,3, 1, 2)));
    }
}
