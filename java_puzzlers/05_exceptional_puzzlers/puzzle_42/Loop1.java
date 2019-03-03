package puzzle_42;

public class Loop1 {
    public static void main(String[] args) {
        int[][] tests = {{6, 5, 4, 3, 2, 1}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}, {1}};
        int successCount = 0;
        for (int i = 0; i < tests.length; i++) {
            if (thirdElementIsThree(tests[i]))
                successCount++;
        }
        System.out.println(successCount);
    }

    private static boolean thirdElementIsThree(int[] a) {
        return a.length >= 3 && a[2] == 3;
    }
}