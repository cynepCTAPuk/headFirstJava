package logical;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -Xss1024M
 */
public class FibonacciStepik {
    private static final int MOD = (int) (1e9 + 7);
    long cnt;

    private int fibonacci6(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return a;
    }

    private void run(int n) {
        System.out.printf("%,d=%,d%n", n, fibonacci6(n));
//        System.out.printf("<%,d> calls%n", cnt);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new FibonacciStepik().run(100_000);
        long finish = System.nanoTime();
        System.out.printf("--- %,d ns%n", finish - start);
    }

    private long fibonacci1(int n) {
        cnt++;
        if (n < 2) return n;
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    private BigInteger fibonacci2(int n) {
        cnt++;
        if (n < 2) return BigInteger.valueOf(n);
        if (cache3.containsKey(n))
            return cache3.get(n);
        else {
            BigInteger res = fibonacci2(n - 1).add(fibonacci2(n - 2));
            cache3.put(n, res);
            return res;
        }
    }

    Map<Integer, BigInteger> cache3 = new HashMap<>();


    private BigInteger fibonacci3(int n) {
        cnt++;
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        if (cache3.containsKey(n)) {
            return cache3.get(n);
        } else {
            for (int i = 2; i <= n; i++) {
                BigInteger res = fibonacci3(i - 1).add(fibonacci3(i - 2));
                cache3.put(i, res);
            }
            return cache3.get(n);
        }
    }

    List<BigInteger> cache4 = new ArrayList<>();


    {
        cache4.add(BigInteger.ZERO);
        cache4.add(BigInteger.ONE);
    }

    private BigInteger fibonacci4(int n) {
        for (int i = cache4.size(); i <= n; i++) {
            BigInteger res = cache4.get(i - 1).add(cache4.get(i - 2));
            cache4.add(res);
        }
        return cache4.get(n);
    }

    List<Integer> cache5 = new ArrayList<>();

    {
        cache5.add(0);
        cache5.add(1);
    }

    private int fibonacci5(int n) {
        for (int i = cache5.size(); i <= n; i++) {
            int res = (cache5.get(i - 1) + cache5.get(i - 2)) % MOD;
            cache5.add(res);
        }
        return cache5.get(n);
    }
}
