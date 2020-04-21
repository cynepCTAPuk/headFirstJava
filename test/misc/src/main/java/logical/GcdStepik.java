package logical;

import java.math.BigInteger;

public class GcdStepik {
    private BigInteger gcd(BigInteger a, BigInteger b) {
        while (true) {
            System.out.println(a + " " + b);
            if (a.equals(BigInteger.ZERO)) return b;
            if (b.equals(BigInteger.ZERO)) return a;
            if (a.compareTo(b) >= 0) a = a.mod(b);
            else b = b.mod(a);
        }
    }

    private void run() {
//        System.out.printf("%,d%n", gcd3(1141 * 2231 * 11, 1141 * 5412));
        BigInteger a = new BigInteger("1234567890");
        BigInteger b = new BigInteger("123456789012345678901234567890123456789012345678901234567890");
        System.out.printf("%,d%n", gcd(new BigInteger("1234567890"), new BigInteger("123456789012345678901234567890123456789012345678901234567890")));
        System.out.printf("%,d%n", a.gcd(b));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new GcdStepik().run();
        long finish = System.nanoTime();
        System.out.printf("%,d ns%n", finish - start);
    }

    private int gcd1(int a, int b) {
        int result = 0;
        for (int i = 1; i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }

    private long gcd2(long a, long b) {
        System.out.println(a + " " + b);
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) {
            return gcd2(a % b, b);
        } else return gcd2(a, b % a);
    }

    private long gcd3(long a, long b) {
        while (true) {
            System.out.println(a + " " + b);
            if (a == 0) return b;
            if (b == 0) return a;
            if (a >= b) a %= b;
            else b %= a;
        }
    }
}
