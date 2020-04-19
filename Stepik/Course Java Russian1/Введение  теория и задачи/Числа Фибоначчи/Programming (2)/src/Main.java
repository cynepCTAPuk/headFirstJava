import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://en.wikipedia.org/wiki/Pisano_period
 * https://way23.ru/%D0%BF%D0%BE%D0%B8%D1%81%D0%BA-%D0%BF%D0%B5%D1%80%D0%B8%D0%BE%D0%B4%D0%B0-%D0%BF%D0%B8%D0%B7%D0%B0%D0%BD%D0%BE/
 *
 */
class Main {
    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
*/
        // 2:3 3:8 4:6 5:20 6:24 7:16 8:12 9:24 10:60 11:10 12:23
        int m = 10;
        int period = 10;
        List<Long> list = new ArrayList<>();
        for (int n = 0; n < 90; n++) {
            long f = fib(n);
            list.add(f % m);
//            System.out.printf("%7d:%d", f, f % m);
//            if (n % period == period - 1) System.out.println();
        }
        System.out.println(list);
    }

    static long fib(int n) {
        if (n < 1) return 0;
        if (n < 3) return 1;
        long a = 1L;
        long b = 1L;
        long c = 0L;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}