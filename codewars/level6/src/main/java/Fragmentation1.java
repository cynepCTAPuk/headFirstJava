public class Fragmentation1 {
    static long n = 0;
    static int cnt = 0;
    static long[] a = new long[10_000];

    public static boolean isPrime(long x) {
        long p = 2;
        while (p * p <= x) {
            if (x % p == 0)
                return false;
            p++;
        }
        return true;
    }

    public static void rec(long x, long last) {
        int i = 0;
        if (x == 0) {
            for (; i < cnt; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
        } else {
            i = (int) last;
            for (; i < x; i++) {
                if (isPrime(x)) {
                    cnt++;
                    a[cnt] = i;
                    rec(x - i, i);
                    cnt--;
                }
            }
        }
    }

    public static void main(String[] args) {
        rec(10, 2);
    }
}