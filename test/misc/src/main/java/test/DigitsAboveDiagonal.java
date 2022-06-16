package test;

import java.util.Arrays;

public class DigitsAboveDiagonal {
    public static void main(String[] args) {
        int n = 5;
        int[][] area = new int[n][n];
        for (int i = 0, num = 1; i < n; i++) {
            if ((i & 1) == 0) {
                for (int j = 0; j <= i; j++) area[j][i] = num++;
            } else {
                for (int j = i; j >= 0; j--) area[j][i] = num++;
            }
        }
        System.out.println(Arrays.deepToString(area));
    }
}
