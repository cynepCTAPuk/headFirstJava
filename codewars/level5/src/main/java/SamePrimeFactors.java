import java.util.*;

public class SamePrimeFactors {

    public static int[] sameFactRev(int nMax) {
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i < nMax; i++) {
            Set<Integer> set1 = factors(i);
            Set<Integer> set2 = factors(reverse(i));
            if (set1.equals(set2)) list.add(i);
        }
        System.out.println(list);
        return new int[0];
    }

    public static Set<Integer> factors(int n) {
        Set<Integer> set = new TreeSet<>();
        for (int factor = 2; factor <= n; ++factor)
            while (n % factor == 0) {
                n = n / factor;
                set.add(factor);
            }
        return set;
    }

    public static int reverseByString(int n) {
        return Integer.parseInt(new StringBuilder().append(n).reverse().toString());
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


    public static void main(String[] args) {
        System.out.println(factors(1089));
        System.out.println(factors(9801));
        System.out.println(factors(2178));
        System.out.println(factors(8712));

        System.out.println(factors(62));

        System.out.println(reverseByString(1089));
        System.out.println(reverseByString(9));

        System.out.println(reverse(1089));
        System.out.println(reverse(9));
        sameFactRev(1100);
    }
}