import java.util.Map;
import java.util.TreeMap;

/**
 * Singular integer right triangles
 * <p>
 * Problem 75
 * It turns out that 12 cm is the smallest length of wire that can be bent to form
 * an integer sided right angle triangle in exactly one way, but there are many more examples.
 * 12 cm: (3,4,5)
 * 24 cm: (6,8,10)
 * 30 cm: (5,12,13)
 * 36 cm: (9,12,15)
 * 40 cm: (8,15,17)
 * 48 cm: (12,16,20)
 * In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided
 * right angle triangle, and other lengths allow more than one solution to be found; for example,
 * using 120 cm it is possible to form exactly three different integer sided right angle triangles.
 * <p>
 * 120 cm: (30,40,50), (20,48,52), (24,45,51)
 * <p>
 * Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly
 * one integer sided right angle triangle be formed?
 */
public class n075_2 {
    public static void main(String[] args) {
        int size = 200_000;
        int[] length = new int[size + 1];

        for (int i = 1; i < 1_000; i += 2) {
            for (int j = 2; j <= 1_000; j += 2) {

                if (gcd(i, j) != 1) continue;

                int a = Math.abs(i * i - j * j);
                int b = 2 * i * j;
                int c = i * i + j * j;
                int sum = a + b + c;

                int t = sum;
                while (t <= size) {
                    length[t]++;
                    t += sum;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < length.length; i++) if (length[i] == 1) count++;
        System.out.println(count);
    }

    static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        return a + b;
    }

    private static boolean isPerfectSquare(long n) {
        if (n < 0) return false;
        switch ((int) (n & 0xF)) {
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
}