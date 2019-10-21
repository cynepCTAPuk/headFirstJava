import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Integer right triangles
 * <p>
 * Problem 39
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * <p>
 * 840:8
 */
public class n039 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        int n = 700;
        int p = 0;
        int maxPerimetr = 1_000;
        while (p <= maxPerimetr) {
            for (int a = 1; a < maxPerimetr / 3; a++) {
                for (int b = a; b < (maxPerimetr - a) / 2; b++) {
                    long sumSquare = a * a + b * b;
                    if (isPerfectSquare(sumSquare)) {
                        int c = (int) Math.sqrt(sumSquare);
                        p = a + b + c;
//                        System.out.println(a + " + " + b + " + " + c + " =  " + p);
                        if (p <= 1_000) map.merge(p, 1, Integer::sum);
                    }
                }
            }
        }
        System.out.println(map);
        Integer key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(key + ":" + map.get(key));
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
