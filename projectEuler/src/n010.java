/**
 * Summation of primes
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * Quantity of Primes before 2,000,000 = 148,933
 * Sum of all Primes before 2,000,000 = 142,913,828,922
 * Time calculation =        8,569,230,684
 */

import java.util.ArrayList;
import java.util.List;

public class n010 {
    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        int n = 2_000_000;
        long sum = 0L;
        long t0, t1;
        int k = 1;
        t0 = System.nanoTime();
        for (int i = 1; i < n; i++) {
            if (isPrime(i, primes)) {
                k++;
                if (k % 10 == 1) System.out.println();
            }
        }
        t1 = System.nanoTime();
        for (Integer i : primes) sum += i;
        System.out.printf("\nQuantity of Primes before %,d = %,d\n", n, primes.size());
        System.out.printf("Sum of all Primes before %,d = %,d\n", n, sum);
        System.out.printf("Time calculation = %,20d\n", t1 - t0);
    }

    static boolean isPrime(int n, List<Integer> primes) {
        if (n < 2) return false;
        for (Integer i : primes) {
            if (n % i == 0) return false;
            if (i * i > n) break;
        }
        primes.add(n);
        return true;
    }
}