package p010;

/**
 * 10001st prime
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * 10001:104743
 */
public class n007 {
    public static void main(String[] args) {
        int i = 1;
        int n = 2;
        while (true) {
            if (isPrime(n)) {
                if (i == 10_001) break;
                i++;
            }
            n++;
        }
        System.out.println(i + ":" + n);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}