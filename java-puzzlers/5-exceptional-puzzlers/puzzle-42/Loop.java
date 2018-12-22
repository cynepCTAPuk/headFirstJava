public class Loop {
    public static void main(String[] args) {
        int[][] tests = {
                {6, 5, 4, 3, 2, 1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4},
                {1}};
        int n = 0;

        try {
            int i = 0;
            while (true) {
                System.out.println("i = " + i);
                if (thirdElementIsThree(tests[i++])) {
                    n++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // No more tests to process
        }
        System.out.println("n = " + n);
    }

    private static boolean thirdElementIsThree(int[] a) {
        return a.length >= 3 & a[2] == 3;
    }
}
