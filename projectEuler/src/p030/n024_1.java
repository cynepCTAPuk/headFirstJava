package p030;

import java.util.Arrays;

/**
 * Lexicographic permutations
 * Problem 24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * WolfAlpha Sun, 15 Sep 2019, 16:40
 */
public class n024_1 {
    public static void main(String[] args) {
        int n = 10;
        int[] changeFrequency = new int[n];
        int[] numbers = new int[n];

        for (int i = 0, j = 1; i < n - 1; i++) {
            j *= (i + 1);
            changeFrequency[i + 1] = j;
            numbers[i] = i;
        }

        numbers[n - 1] = n - 1;
        int position = 1000000 - 1;
        int[] output = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int factor = position / changeFrequency[n - (i + 1)];
            position %= changeFrequency[n - (i + 1)];
            System.out.println(factor + "  " + position);
            int pick = -1;
            while (factor != -1) {
                pick++;
                if (numbers[pick] > -1) {
                    factor--;
                }
            }
            output[i] = numbers[pick];
            numbers[pick] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (numbers[i] > -1) {
                output[n - 1] = numbers[i];
                break;
            }
        }

        System.out.println(Arrays.toString(output));
    }
}
