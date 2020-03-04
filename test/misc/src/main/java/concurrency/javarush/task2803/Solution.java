package concurrency.javarush.task2803;

import java.util.concurrent.ThreadLocalRandom;

/*
ThreadLocalRandom
*/
public class Solution {

    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextInt(from, to);
    }

    public static double getRandomDouble() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextLong(n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) System.out.print(getRandomIntegerBetweenNumbers(10, 20) + " ");
        System.out.println();
        for (int i = 0; i < 5; i++) System.out.print(getRandomDouble() + " ");
        System.out.println();
        for (int i = 0; i < 50; i++) System.out.print(getRandomLongBetween0AndN(10) + " ");
    }
}
