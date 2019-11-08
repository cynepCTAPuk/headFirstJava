package p030;

/**
 * Number spiral diagonals
 * Problem 28
 * Published on 11 October 2002 at 06:00 pm [Server Time]
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * <p>
 * 669171001
 */
public class n028 {
    public static void main(String[] args) {
        int n = 1001;
        long t0, t1, t2;
        t0 = System.nanoTime();
        System.out.println(diagonalSum(n));
//        System.out.println(javaManIssa(n));
        t1 = System.nanoTime() - t0;

        t0 = System.nanoTime();
        System.out.println(thePrashanthK(501));
        t2 = System.nanoTime() - t0;

        System.out.println(t1 + "\n" + t2);
    }

    static long diagonalSum(int n) {
        if (n % 2 == 0) return -1;
        if (n == 1) return 1;
        int n1 = n * n;
        int n2 = n1 - (n - 1);
        int n3 = n2 - (n - 1);
        int n4 = n3 - (n - 1);
        return diagonalSum(n - 2) + n1 + n2 + n3 + n4;
    }

    // JavaManIssa Sun, 18 Sep 2005, 14:31
    static long javaManIssa(int n) {
        long counter = 1L;
        int index = 1;
        for (int k = 2; k < n; k += 2) {
            for (int p = 0; p < 4; p++) {
                index += k;
                counter += index;
            }
        }
        return counter;
    }

    // Sergey_USB Sun, 2 Jun 2019, 14:34
    static long sergeyUSB(int n) {
        long sum = 1L;
        for (int i = 3; i <= n; i = i + 2) {
            sum = sum + i * i;
            sum = sum + i * i - (i - 1);
            sum = sum + i * i - (i * 2 - 2);
            sum = sum + i * i - (i * 3 - 3);
        }
        return sum;
    }

    // thePrashanthK Fri, 14 Jun 2019, 09:20
    static long thePrashanthK(int n) {
        return 2 * (n - 1) * (8 * n * n - n + 6) / 3 + 1;

    }
}
