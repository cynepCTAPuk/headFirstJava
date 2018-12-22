import java.util.*;

public class Loop {
    public static void main(String[] args) {
        int[][] tests = {
                {6, 5, 4, 3, 2, 1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4},
                {1}};
        int n = 0;
        for (int i = 0; i < tests.length; i++) {
            System.out.println("i = " + i + " " + Arrays.toString(tests[i]));
        }

        try {
            int idx = 0;
            while (true) {
                System.out.println("idx = " + idx);
                if (thirdElementIsThree(tests[idx++])) {
                    n++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch n = " + n);
            // No more tests to process
        }
        System.out.println("n = " + n);
    }

    private static boolean thirdElementIsThree(int[] array) {
        System.out.println("array.length = " + array.length + " array[2] = " + array[2]);
        return array.length >= 3 & array[2] == 3;
    }
}
