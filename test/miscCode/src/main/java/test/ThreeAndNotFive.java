package test;

import java.util.ArrayList;
import java.util.List;

public class ThreeAndNotFive {
    public static final int MAX_LIMIT = 100_000_000;

    public static void main(String[] args) {
        int max = 10;
        String format = "%,14d%n";

        long s1 = System.nanoTime();
        List<Integer> x1 = getX1(max);
        long p1 = System.nanoTime() - s1;
        System.out.printf(format, p1);
        System.out.println("size=" + x1.size());

        long s2 = System.nanoTime();
        List<Integer> x2 = getX2(max);
        long p2 = System.nanoTime() - s2;
        System.out.printf(format, p2);
        System.out.println("size=" + x2.size());

        System.out.printf(format, p2 - p1);
    }

    private static List<Integer> getX1(int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = 3; i < MAX_LIMIT; i += 3) {
            if (i % 5 == 0) continue;
            if (!sumOfDigitsLessThenMaxFor(i, max)) continue;
            list.add(i);
        }
        return list;
    }

    private static List<Integer> getX2(int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = 3; i < MAX_LIMIT; i += 3) {
            if (i % 5 == 0) continue;
            if (!sumOfDigitsLessThenMaxWhile(i, max)) continue;
            list.add(i);
        }
        return list;
    }

    static boolean sumOfDigitsLessThenMaxFor(int input, int max) {
        int sum;
        for (sum = 0; input != 0; input = input / 10) {
            sum += input % 10;
            if (sum >= max) return false;
        }
        return true;
    }

    static boolean sumOfDigitsLessThenMaxWhile(int input, int max) {
        int sum = 0;
        while (input > 0) {
            sum += input % 10;
            input = input / 10;
            if (sum >= max) return false;
        }
        return true;
    }
}
