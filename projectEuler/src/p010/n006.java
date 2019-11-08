package p010;

/**
 * Sum square difference
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers
 * and the square of the sum.
 */
public class n006 {
    public static void main(String[] args) {
        long sumOfSquares = 0;
        long squareOfSum = 0;
        int n = 100;
        for (int i = 1; i <= n; i++) {
            sumOfSquares += i * i;
            squareOfSum += i;
        }
        squareOfSum *= squareOfSum;
        System.out.printf("%,12d\n", squareOfSum);
        System.out.printf("- %,10d\n", sumOfSquares);
        System.out.printf("= %,10d", squareOfSum - sumOfSquares);
    }
}
