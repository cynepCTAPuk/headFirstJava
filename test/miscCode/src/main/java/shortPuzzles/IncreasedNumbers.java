package shortPuzzles;

import java.util.LinkedList;
import java.util.List;

public class IncreasedNumbers {
    public static void main(String[] args) {
        List<Long> list = new LinkedList<>();

        long N = Long.MAX_VALUE >> 32;
        System.out.printf("%,20d\n", N);
        long current = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            if (isBigger(current++)) list.add(current);
        }
        System.out.printf("%,20d\n", list.size());
        System.out.printf("Time = %,d\n", System.currentTimeMillis() - start);
    }

    public static boolean isBigger(long current) {
        int b = (int) (current % 10);
        int p = b;
        while (current >= 1) {
            if (p + 1 < b) return false;
            p = b;
            current /= 10;
            b = (int) (current % 10);
        }
        return true;
    }

    public static List<Integer> integerList(Long a) {
        List<Integer> list = new LinkedList<>();
        int b = (int) (a % 10);
        while (a >= 1) {
            list.add(0, b);
            a /= 10;
            b = (int) (a % 10);
        }
        return list;
    }

    public static void excludeLessDigits(List<Integer> integers) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                String s = i + "" + j;
                integers.add(i * 10 + j);
            }
        }
    }

    public static int armstrongSum(int a) { // считаю сумму числа по "системе армстронга" будь он неладен
        int sum = 0;
        int d = lengthNumber(a);
        int b = a % 10;
        while (a >= 1) {
            sum += pow(b, d);
            a /= 10;
            b = a % 10;
        }
        return sum;
    }

    public static int lengthNumber(int a) {  //считаю длину числа
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
