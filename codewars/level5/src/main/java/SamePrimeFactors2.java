import java.util.*;

public class SamePrimeFactors2 {
    static long time = System.currentTimeMillis();
    static Set<Integer> set = new TreeSet<>();

    public static int[] sameFactRev(int nMax) {
        int a = 2 * 3 * 3 + 1;
        int b = 3 * 3 * 3;
        Thread thread1 = new Thread(() -> getPrimeFactor(0, nMax * a / b));
        Thread thread2 = new Thread(() -> getPrimeFactor(nMax * a / b, nMax));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>(set);
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) ints[i] = list.get(i);
//        Arrays.sort(ints);
        return ints;
    }

    private static void getPrimeFactor(int i1, int i2) {
        for (int i = i1; i < i2; i++) {
            if (i % 10 == 0) continue;
            if (i == reverse(i)) continue;
            int j = reverse(i);
            List list1 = factors(i);
            List list2 = factors(j);
            if (list1.equals(list2)) {
                set.add(i);
                System.out.printf("%,8d ms ", System.currentTimeMillis() - time);
                System.out.printf("%,8d %,8d %s\n", i, j, list1);
            }
        }
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
        t1 = System.nanoTime();
        int nMax = 100_000;
        int[] ints = sameFactRev(nMax);
        System.out.println(Arrays.toString(ints));
        System.out.println("Size of ints: " + ints.length);
        System.out.printf("All elements: %,d\n", nMax);
        System.out.printf("%,16d nanosecond\n", System.nanoTime() - t1);
    }
}