package shortPuzzles;

import java.util.ArrayList;
import java.util.stream.IntStream;

/*
Алгоритмы-числа
http://www.cyberforum.ru/java-j2se/thread1743615.html
средний результат

*/
public class ArmstrongNums4 {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
//        long N = Long.MAX_VALUE >> 32;
        int N = 100_000_000;
        long start = System.currentTimeMillis();
        IntStream.range(1, N)
                .map(i -> {
                    int estimate = i;
                    int sumPows = 0;
                    int pow = (int) Math.log10(i) + 1;
                    while (i != 0) {
                        sumPows += (int) Math.pow(i % 10, pow);
                        i /= 10;
                    }
                    if (sumPows == estimate) return estimate;
                    return -1;
                })
                .filter(x -> x != -1)
                .forEach(x1 -> arrayList.add(x1));
        long end = System.currentTimeMillis() - start;
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.printf("Time = %,d\n", end);
        System.out.println("Memory = " + memory / 1024 / 1024);
        System.out.println(arrayList);
    }
}