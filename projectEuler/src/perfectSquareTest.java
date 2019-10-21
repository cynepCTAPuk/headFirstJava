/**
 * https://stackoverflow.com/questions/295579/fastest-way-to-determine-if-an-integers-square-root-is-an-integer
 */
public class perfectSquareTest {
    public static void main(String[] args) {
        int n = 1_000_000_000;
        int m = 1_000_000;
        test0(n, m);
        test1(n, m); // the best
        test2(n, m);
    }

    private static void test0(int n, int m) {
        long t0;
        t0 = System.nanoTime();
        int qty = 0;
        for (int i = 0; i < m; i++) {
            int number = n + i;
            if (isPerfectSquare(number)) {
                qty++;
//                System.out.print(qty + ": " + number + " ");
            }
        }
        System.out.print("qty: " + qty);
        System.out.printf( " test0 - %,15d\n", System.nanoTime() - t0);
    }

    private static void test1(int n, int m) {
        long t0;
        t0 = System.nanoTime();
        int qty = 0;
        for (int i = 0; i < m; i++) {
            int number = n + i;
            if (isPerfectSquare1(number)) {
                qty++;
//                System.out.print(qty + ": " + number + " ");
            }
        }
        System.out.print("qty: " + qty);
        System.out.printf( " test1 - %,15d\n", System.nanoTime() - t0);
    }

    private static void test2(int n, int m) {
        long t0;
        t0 = System.nanoTime();
        int qty = 0;
        for (int i = 0; i < m; i++) {
            int number = n + i;
            if (isPerfectSquare2(number)) {
                qty++;
//                System.out.print(qty + ": " + number + " ");
            }
        }
        System.out.print("qty: " + qty);
        System.out.printf( " test2 - %,15d\n", System.nanoTime() - t0);
    }

    private static boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        int test = (int) (Math.sqrt(n) + 0.5);
        return test * test == n;
    }

    private static boolean isPerfectSquare1(int n) {
        if (n < 0) return false;
        switch (n & 0xF) {
            case 0:
            case 1:
            case 4:
            case 9:
                long tst = (long) Math.sqrt(n);
                return tst * tst == n;
            default:
                return false;
        }
    }

    private static boolean isPerfectSquare2(int n) {
        int h = n & 0xF;  // h is the last hex "digit"
        if (h > 9) return false;
        // Use lazy evaluation to jump out of the if statement as soon as possible
        if (h != 2 && h != 3 && h != 5 && h != 6 && h != 7 && h != 8) {
            int t = (int) Math.floor(Math.sqrt(n) + 0.5);
            return t * t == n;
        }
        return false;
    }
}