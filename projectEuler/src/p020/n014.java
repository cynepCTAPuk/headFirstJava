package p020;

/**
 * Longest Collatz sequence
 * <p>
 * Problem 14
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class n014 {
    public static void main(String[] args) {
        final int n = 1_000_000;
        f(n);
    }

    static void f(int n) {
        long max = 0L;
        long result = 0L;

        for (int i = 2; i <= n; i++) {
            int len = 1;
            long seq = i;
            while (seq != 1) {
                if (seq % 2 == 0) seq = seq / 2;
                else seq = seq * 3 + 1;
                len++;
            }
            if (len > max) {
                max = len;
                result = i;
            }
        }
        System.out.println(result);
        System.out.println(max);
    }
}
