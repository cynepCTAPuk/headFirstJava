import java.util.ArrayList;
import java.util.List;

/**
 * Pandigital prime
 * <p>
 * Problem 41
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 */

public class n041___ {
    public static void main(String[] args) {
        List<Long> primes = new ArrayList<>();
        long begin = 9_876_500_000L;
        long end = 9_876_543_210L;
        long t0, t1;
        t0 = System.nanoTime();

        for (long i = 1; i < end; i++) {
            if (isPrime(i, primes) & i > begin) System.out.print(i + " ");
        }

        t1 = System.nanoTime();

        System.out.printf("\nQuantity of Primes = %,d\n", primes.size());
        System.out.printf("Time calculation = %,20d\n", t1 - t0);
    }

    static boolean isPrime(long n, List<Long> primes) {
        if (n < 2) return false;
        for (Long i : primes) {
            if (n % i == 0) return false;
            if (i * i > n) break;
        }
        primes.add(n);
        return true;
    }
}