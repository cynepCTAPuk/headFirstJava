package shortPuzzles;

import java.util.ArrayList;

/*
Алгоритмы-числа
http://www.cyberforum.ru/java-j2se/thread1743615.html
*/
public class ArmstrongNums1 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
//        long N = Long.MAX_VALUE >> 32;
        int N = 100_000_000;
        long start = System.currentTimeMillis();
        int[] array = getNumbers(N);
        long end = System.currentTimeMillis() - start; // считаю сколько секунд длилась "программа"
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // считаю сколько памяти было занято.

        System.out.printf("Time = %,d\n", end);
        System.out.println("Memory = " + memory / 1048576);

        for (int a : array) if (a != 0) System.out.print(a + " ");
    }

    public static int[] getNumbers(long N) {  //метод который дается по заданию
        for (int i = 0; i <= N; i++) {
            if (sum(i) == i) arrayList.add(i);
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) result[i] = arrayList.get(i);
        return result;
    }

    public static int sum(int a) { // считаю сумму числа по "системе армстронга" будь он неладен
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