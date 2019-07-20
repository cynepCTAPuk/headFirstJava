public class Divisors {
    static void printDivisors(int n) {
        for (int i = 1; i <= n; i++)
            if (n % i == 0) System.out.printf("%3d ", i);
        System.out.println();
    }

    public static void main(String args[]) {
        printDivisors(10);
        printDivisors(50);
        printDivisors(100);
        printDivisors(500);
    }
}