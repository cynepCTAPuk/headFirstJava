package logical.task3904;

/*
Лестница
*/
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) return 0L;
        if (n == 0 || n == 1) return 1L;
        if (n == 2) return 2L;
        long result = 0L;
        long n0 = 1L;
        long n1 = 1L;
        long n2 = 2L;
        for (int i = 0; i < n - 2; i++) {
            result = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}

