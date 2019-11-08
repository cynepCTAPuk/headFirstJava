package p030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lexicographic permutations
 * Problem 24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * whizter Sun, 24 Jun 2007, 16:38
 */
public class n024_3 {
    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 1; i <= 1_000_000; nextPerm(a), ++i)
        System.out.print(Arrays.toString(a));
    }

    static boolean nextPerm(int a[]) {
        for (int n = a.length - 1, i = n, j; i > 0; )
            if (a[i--] > a[i]) {
                for (j = n; a[j] <= a[i]; j--) ;
                a[j] = a[j] ^ a[i] ^ (a[i] = a[j]);
                for (j = i, i = n + i >> 1; ++j <= i; a[j] = a[j] ^ a[n] ^ (a[n--] = a[j])) ;
                return true;
            }
        return false;
    }
}