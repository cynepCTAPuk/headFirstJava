/**
 * Smallest multiple
 * 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class n005 {
    public static void main(String[] args) {
        int number = 2 * 3 * 5 * 7 * 11 * 13 * 17 * 19;
        System.out.printf("%,11d\n", number);
        int n = 20;
        boolean check = false;
        while (!check) {
            number++;
            if (isDividedByAll(number, n))
                check = true;
        }
        System.out.printf("%,11d\n", number);
    }

    public static boolean isDividedByAll(int number, int n) {
        for (int i = n / 2; i <= n; i++)
            if (number % i != 0) return false;
        return true;
    }
}
