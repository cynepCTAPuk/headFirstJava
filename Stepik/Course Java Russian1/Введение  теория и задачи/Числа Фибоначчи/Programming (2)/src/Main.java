import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://en.wikipedia.org/wiki/Pisano_period
 * https://way23.ru/%D0%BF%D0%BE%D0%B8%D1%81%D0%BA-%D0%BF%D0%B5%D1%80%D0%B8%D0%BE%D0%B4%D0%B0-%D0%BF%D0%B8%D0%B7%D0%B0%D0%BD%D0%BE/
 */
class Main {
    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
*/
        // 2:3 3:8 4:6 5:20 6:24 7:16 8:12 9:24 10:60 11:10 12:23
        long n = 80; // Fibonacci's number
        long m = 50; // divider
        long a = 1, b = 0;
        long p = 0;
        List<Long> list = new ArrayList<>();
        list.add(0L);
        for (long i = 1; i <= n; i++) {
            b = fib(i);
            System.out.print(b + ":");
            b = b % m;
//            System.out.print(b + " ");
            if (a == 0 && b == 1) {
                p = i;
                System.out.println("<" + p + ">");
                break;
            }
            list.add(b);
            a = b;
        }
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println("остаток от деления: " + fib(n) % m);
        System.out.println(list.get((int) (n % p + 1)));

//        System.out.println(fib(3));
    }

    static long fib(long n) {
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