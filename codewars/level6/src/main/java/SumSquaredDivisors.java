public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        String listSum = "";
        for (int i = 0; i <= n - m; i++) {
            listSum += String.format("%,7d",sumSquaredDivisors(m + i));
        }
        return listSum;
    }

    private static long sumSquaredDivisors(long n) {
        long sum = 0L;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                sum += i*i;
        return sum;
    }

    public static void main(String args[]) {
        System.out.println(listSquared(40, 50));
        System.out.println(listSquared(240, 250));
    }
}
