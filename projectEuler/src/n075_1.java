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
public class n075_1 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        int maxLength = 1_000;
        int limit = (int) Math.sqrt(maxLength);
        for (long n = 1; n < limit; n++) {
            for (long m = n + 1; m < limit; m++) {

                long a = m * m - n * n;
                long b = 2 * n * m;
                long c = n * n + m * m;

                long p = a + b + c;
                if (p <= maxLength) {
                    System.out.print(a + "+" + b + "+" + c + "=" + p + ", ");
                    map.merge((int) p, 1, Integer::sum);
                }
            }
        }
//        System.out.println();
//        System.out.println(map);
        int size = map.size();
        System.out.printf("\nmaxLength: %,d\n", maxLength);
        System.out.printf("map size: %,d\n", size);
        int qty = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                qty++;
//                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.printf("qty unique length: %,d\n", +qty);
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