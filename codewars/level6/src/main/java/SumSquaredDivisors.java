import java.util.ArrayList;
import java.util.List;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= n - m; i++) {
            if (isSquared(sumSquaredDivisors(m + i)))
                list.add(String.format("[%d, %d]", (m + i), sumSquaredDivisors(m + i)));
        }
        return list.toString();
    }

    private static long sumSquaredDivisors(long n) {
        long sum = 0L;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                sum += i * i;
        return sum;
    }

    private static boolean isSquared(long n) {
        long side = 1;
        while (side * side != n) {
            if (side * side > n) return false;
            side++;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(listSquared(1, 246));
        System.out.println(listSquared(50, 60));
//        System.out.println(listSquared(240, 250));
//        System.out.println(isSquared(2));
    }
}
