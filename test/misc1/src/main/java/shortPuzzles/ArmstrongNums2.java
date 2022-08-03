package shortPuzzles;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Алгоритмы-числа
http://www.cyberforum.ru/java-j2se/thread1743615.html
1,000,000,000
Time = 5,653
Memory = 3
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834,
 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153]
*/
public class ArmstrongNums2 {
    static Set<Long> set = new LinkedHashSet<>();

    public static void main(String[] args) {
//        long N = Long.MAX_VALUE >> 32;
        int N = 1_000_000_000;
        System.out.printf("%,d\n", N);
        long start = System.currentTimeMillis();
        getNumbers(N);
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.printf("Time = %,d\n", System.currentTimeMillis() - start);
        System.out.println("Memory = " + memory / 1024 / 1024);

        System.out.println(set);
    }

    private static void getNumbers(long N) {
        for (int i = 0; i <= N; i++) {
            if (isNumberUnique(i)) {
                long sumOfPowers = sum(i);
                if (isArmstrongNumber(sumOfPowers)) {
                    set.add(sumOfPowers);
                }
            }
        }
    }

    private static boolean isArmstrongNumber(long number) {
        return sum(number) == number;
    }

    private static boolean isNumberUnique(long number) {
        long lastDigit = 0;
        long currentDigit;
        while (number > 0) {
            currentDigit = number % 10;
            if (lastDigit > currentDigit) return false;
            lastDigit = currentDigit;
            number /= 10;
        }
        return true;
    }

    private static long sum(long a) {
        int sum = 0;
        int d = lengthNumber(a);
//        int d = String.valueOf(a).length();
        long b = a % 10;
        while (a >= 1) {
            sum += pow(b, d);
//            sum += Math.pow(b, d);
            a /= 10;
            b = a % 10;
        }
        return sum;
    }

    private static int lengthNumber(long a) {
        int b = 0;
        while (a >= 1) {
            b++;
            a /= 10;
        }
        return b;
    }

    private static long pow(long base, int exp) {
        long result = base;
        for (int i = 1; i < exp; i++) result *= base;
        return result;
    }
}