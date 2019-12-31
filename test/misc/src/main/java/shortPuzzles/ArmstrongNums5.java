package shortPuzzles;

import java.util.*;

/*
Алгоритмы-числа
*/
public class ArmstrongNums5 {
    static Set<Long> set = new TreeSet<>();

    public static void main(String[] args) {
//        long N = Long.MAX_VALUE >> 32;
        int N = 1_000_000;
        System.out.printf("%,d\n", N);
        long start = System.currentTimeMillis();
        getNumbers(N);
        System.out.printf("Time = %,d milliSeconds\n", System.currentTimeMillis() - start);
        System.out.printf("Memory = %,d B\n", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
//        System.out.printf("Memory = %,d MB\n", Runtime.getRuntime().totalMemory());
//        System.out.printf("Memory = %,d MB\n", Runtime.getRuntime().freeMemory());
        System.out.println(set);
    }

    public static void getNumbers(long N) {
        long number = 0;
        for (int i = 0; i <= N; i++) {
            if (isBigger(number)) {
                long sumOfDigits = armstrongSum(number);
                if (isArmstrongNumber(sumOfDigits)) set.add(sumOfDigits);
            }
            number++;
        }
    }

    public static boolean isBigger(long a) {
        int b;
        int p = 0;
        while (a > 0) {
            b = (int) (a % 10);
            if (p > b) return false;
            p = b;
            a /= 10;
        }
        return true;
    }

    private static boolean isArmstrongNumber(long a) {
        return a == armstrongSum(a);
    }

    public static long armstrongSum(long a) { // считаю сумму числа по "системе армстронга" будь он неладен
        int sum = 0;
        int d = lengthNumber(a);
        int b = (int) (a % 10);
        while (a >= 1) {
            sum += pow(b, d);
            a /= 10;
            b = (int) (a % 10);
        }
        return sum;
    }

    public static int lengthNumber(long a) {  //считаю длину числа
        int b = 0;
        while (a >= 1) {
            b++;
            a /= 10;
        }
        return b;
    }

    public static int pow(int base, int exp) { // возвожу число в степень
        int result = base;
        for (int i = 1; i < exp; i++) result *= base;
        return result;
    }
}