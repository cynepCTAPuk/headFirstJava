import java.util.*;

public class SamePrimeFactors {
    static long time = System.currentTimeMillis();

    public static int[] sameFactRev(int nMax) {
/*
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nMax; i++) {
            if (i % 10 == 0) continue;
            if (i == reverse(i)) continue;

            int j = reverse(i);
            List list = factors(i);

            List list2 = factors(j);
            if (list.equals(list2)) {
                set.add(i);
                if (j < nMax) set.add(j);
                System.out.printf("%,8d ms ", System.currentTimeMillis() - time);
                System.out.printf("%,8d %,8d %s\n", i, j, list);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) ints[i] = list.get(i);
        System.out.println(set);
        System.out.println("Size of ints: " + ints.length);
        System.out.printf("All elements: %,d\n", nMax);
*/
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nMax; i++) {
            if (i % 10 == 0) continue;
            if (i == reverse(i)) continue;
            list.add(factors(i));
        }
        return new int[0];
    }

    public static List<Integer> factors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int factor = 2; factor <= n; ++factor) {
            int count;
            for (count = 0; n % factor == 0; ++count) n /= factor;
            if (count > 0) list.add(factor);
        }
        return list;
    }

    public static int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            int remainder = n % 10;
            reverse = reverse * 10 + remainder;
            n /= 10;
        }
        return reverse;
    }

    public static Set<Integer> factorsSet(int n) {
        Set<Integer> set = new TreeSet<>();
        for (int factor = 2; factor <= n; ++factor) {
            while (n % factor == 0) {
                set.add(factor);
                n = n / factor;
            }
        }
        return set;
    }

    public static int reverseByString(int n) {
        return Integer.parseInt(new StringBuilder().append(n).reverse().toString());
    }

    public static void main(String[] args) {
        long t1;
        long t2;
        t1 = System.nanoTime();
        int n = 10_000;
        sameFactRev(n);
//        for (int i = 0; i < n; i++) factors(i);
        System.out.printf("%,16d nanosecond\n", System.nanoTime() - t1);
    }
}