package chap16_arrays;

import java.util.*;

public class Exercise3 {
    static double[][] twoDimArray(int size1, int size2, double start, double end) {
        Random random = new Random();
        double[][] result = new double[size1][size2];

        if (start > end) {
            System.out.println("May be you need to change limits for array");
            return result;
        }

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                result[i][j] = random.nextDouble() * (end - start) + start;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(twoDimArray(2, 2, 2, 1)));
        System.out.println(Arrays.deepToString(twoDimArray(2, 2, 1, 2)));
    }
}
