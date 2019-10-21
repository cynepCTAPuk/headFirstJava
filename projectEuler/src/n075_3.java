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
 *
 * mueslix Wed, 21 Aug 2019, 19:38
 */
public class n075_3 {
    public static void main(String[] args) {
        final long timeStart = System.currentTimeMillis();
        int maxPerimeter = 1_500_000;

        // array to store the lengths, in the index of (a+b+c) set =1 if it is the first
        // time this length is found, else set to -1
        int[] length = new int[maxPerimeter + 1];

        for (long m = 1; m * m < maxPerimeter / 4; m++) {

            for (long n = m + 1; m * m + n * n < maxPerimeter / 2; n += 2) {

                if (gcd(m, n) == 1) {

                    int a = (int) (n * n - m * m);
                    int b = (int) (2 * m * n);
                    int c = (int) (m * m + n * n);

                    int p = (int) (a + b + c);
                    // for the non-primitive triplets

                    for (int k = 1; k * p <= maxPerimeter; k++) {
                        if (length[k * p] == 0) length[k * p] = 1;
                        else length[k * p] = -1;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i < maxPerimeter + 1; i++) if (length[i] == 1) cnt++;
        System.out.println(cnt);
        final long timeEnd = System.currentTimeMillis();
        System.out.println("time: " + (timeEnd - timeStart) + " milliseconds");
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}