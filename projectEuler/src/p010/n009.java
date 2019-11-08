package p010;

/**
 * Special Pythagorean triplet
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class n009 {
    public static void main(String[] args) {
        long s = 1_000L;
        long t0 = System.nanoTime();

        specialPythagoreanTriplet(s);

        System.out.printf("%,d\n", System.nanoTime() - t0);
    }

    static void specialPythagoreanTriplet(long sum) {
        long s2 = sum / 2;
        int limit = (int) Math.sqrt(s2) - 1;
        for (int m = 2; m < limit; m++) {
            if (s2 % m == 0) {
                long sm = s2 / m;
                while (sm % 2 == 0) sm = sm / 2;
                int k;
                if (m % 2 == 1) k = m + 2;
                else k = m + 1;
                while (k < 2 * m & k <= sm) {
                    if (sm % k == 0 & gcd(k, m) == 1) {
                        long d = s2 / (k * m);
                        int n = k - m;
                        long a = d * (m * m - n * n);
                        long b = 2 * d * m * n;
                        long c = d * (m * m + n * n);
                        long prod = a*b*c;
                        System.out.printf("%,10d * %,10d * %,10d = %,15d\n", a, b, c, prod);
                    }
                    k = k + 2;
                } // end while
            } // end if
        } // for
    }

    static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        return a + b;
    }
}
