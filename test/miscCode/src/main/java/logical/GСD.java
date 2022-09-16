package logical;

/**
 * https://en.wikipedia.org/wiki/Greatest_common_divisor
 * https://en.wikipedia.org/wiki/Least_common_multiple
 */
public class GСD {
    public static int count = 0;
    public static final String FORMAT = "%,12d:%,12d%n";

    public static void main(String[] args) {
        int a = 3_918_848;
        int b = 1_653_264;
        a = (int) (Math.random() * 100_000);
        b = (int) (Math.random() * 100_000_000);
        System.out.printf(FORMAT, a, b);
        gcd1(a, b);
        gcd1a(a, b);
        gcd2(a, b);
        System.out.println();
        gcd3(a, b);
        gcd3a(a, b);
        gcd4(a, b);
    }

    private static void gcd1(int a, int b) {
        int count = 1;
        if (a == 0 || b == 0) {
            System.out.printf(FORMAT, 0, count);
            return;
        }
        int result = 1;
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
            count++;
        }
        System.out.printf(FORMAT, result, count);
    }

    private static void gcd1a(int a, int b) {
        int count = 1;
        if (a == 0 || b == 0) {
            System.out.printf(FORMAT, 0, count);
            return;
        }
        int result = 1;
        for (int i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                if (b % i == 0) {
                    result = i;
                }
                int big_d = a / i;
                if (b % big_d == 0) {
                    result = big_d;
                    break;
                }
            }
            count++;
        }
        System.out.printf(FORMAT, result, count);
    }

    private static void gcd2(int a, int b) {
        int count = 1;
        if (a == 0 || b == 0) {
            System.out.printf(FORMAT, 0, count);
            return;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int c;
        while (max - min > 0) {
            c = max - min;
            max = Math.max(c, min);
            min = Math.min(c, min);
            if (max % min == 0) {
                System.out.printf(FORMAT, min, count);
                return;
            }
            count++;
        }
    }

    private static void gcd3(int a, int b) {
        count++;
        if (a == 0) {
            System.out.printf(FORMAT, b, count);
            return;
        }
        if (b == 0) {
            System.out.printf(FORMAT, a, count);
            return;
        }
        if (a >= b) gcd3(a % b, b);
        if (b >= a) gcd3(a, b % a);
    }

    private static void gcd3a(int a, int b) {
        count++;
        if (a == 0) {
            System.out.printf(FORMAT, b, count);
            return;
        }
//        if (b == 0) {
//            System.out.printf(FORMAT, a, count);
//            return;
//        }
        if (b > 0) {
            gcd3(b, a % b);
        }
    }

    private static void gcd4(int a, int b) {
        int count = 1;
        while (a > 0 && b > 0) {
            if (a > b) a %= b;
            else b %= a;
            count++;
        }
        System.out.printf(FORMAT, a + b, count);
    }
}
