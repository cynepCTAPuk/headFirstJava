package recursion.task3403;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }
    }

    void printPrimeFactors(int num) {
        int divisor = 2;
        if (num == 1) return;

        if (num % divisor != 0) while (num % divisor != 0) ++divisor;

        if (num % divisor == 0) {
            System.out.print(divisor + " ");
            printPrimeFactors(num / divisor);
        }
    }

    public static void main(String[] args) {
        new Solution().recurse(132);
        System.out.println();
        new Solution().printPrimeFactors(13);
    }
}
