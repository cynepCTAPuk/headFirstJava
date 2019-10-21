/**
 * Multiples of 3 and 5
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

import java.util.stream.IntStream;

public class n001 {
    public static void main(String[] args) {
        int n = 1_000;
//        for (int i = 0; i < n; i++) if (i % 3 == 0 | i % 5 == 0) sum += i;
        int sum = IntStream.range(0, n).filter(i -> i % 3 == 0 | i % 5 == 0).sum();
        System.out.println(sum);
    }
}
