package shortPuzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Алгоритмы-числа
N = Long.MAX_VALUE >> 32 = Integer.MAX_VALUE = 2,147,483,647
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725,
 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153]
Time: 197,540 milliSeconds
- need to improve!
*/
public class ArmstrongNumbers {
    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            int M = chars.length;
            int[] ints = new int[M];
            for (int j = 0; j < M; j++) ints[j] = (int) chars[j] - 48;

            long S = 0;
            for (int j = 0; j < M; j++) {
                int d = ints[j];
                long mult = 1;
                for (int k = 0; k < M; k++) mult = mult * d;
                S += mult;
            }
            if (S == i) list.add(S);
        }

        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {
//        long N = Long.MAX_VALUE >> 32;
        long N = 100_000_000;
        System.out.printf("%,26d\n", Long.MAX_VALUE);
        System.out.printf("%,26d\n", Integer.MAX_VALUE);
        System.out.printf("%,26d\n", N);

        long start = System.currentTimeMillis();
        long[] result = getNumbers(N);
        System.out.printf("%,d\n", System.currentTimeMillis() - start);

        System.out.println(Arrays.toString(result));

    }
}
