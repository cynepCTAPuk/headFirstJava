package shortPuzzles;

import java.util.ArrayList;

/*
Алгоритмы-числа
http://www.cyberforum.ru/java-j2se/thread1743615.html
медленно, но кратко

*/
public class ArmstrongNums3 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
//        long N = Long.MAX_VALUE >> 32;
        int N = 100_000_000;
        long start = System.currentTimeMillis();
        for (int i = 1; i < N; i++) {
            if (isArmstrongNun(String.valueOf(i))) arrayList.add(i);
        }
        long end = System.currentTimeMillis() - start;
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.printf("Time = %,d\n", end);
        System.out.println("Memory = " + memory / 1024 / 1024);
        System.out.println(arrayList);
    }

    private static boolean isArmstrongNun(String testNum) {
        long nn = testNum
                .chars()
                .map(ch -> ch - '0')
                .map(i -> (int) Math.pow(i, testNum.length()))
                .sum();
        return nn == Long.parseLong(testNum, 10);
    }
}