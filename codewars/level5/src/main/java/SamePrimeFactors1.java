import java.util.*;

public class SamePrimeFactors1 {

    public static int[] sameFactRev(int nMax) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1000; i < nMax; i++) {
            if (i != reverse(i))
                if (factors(i).equals(factors(reverse(i))))
                    list.add(i);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length ; i++) result[i] = list.get(i);
        return result;
    }

    public static Set<Integer> factors(int n) {
        Set<Integer> set = new HashSet<>();
        for (int factor = 2; factor <= n; ++factor)
            while (n % factor == 0) {
                n = n / factor;
                set.add(factor);
            }
        return set;
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

    public static int reverseByString(int n) {
        return Integer.parseInt(new StringBuilder().append(n).reverse().toString());
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(sameFactRev(100_000)));
        System.out.println(System.currentTimeMillis() - t1);
    }
}