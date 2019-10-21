import java.math.BigInteger;

/**
 * Factorial digit sum
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 *
 * Product: 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
 * Length of product: 158
 * Sum of all digits of product: 648
 */
public class n020 {
    public static void main(String[] args) {
        BigInteger product = new BigInteger("1");
        for (int i = 1; i <= 100; i++) {
            product = product.multiply(new BigInteger(String.valueOf(i)));
        }
        String factorial = product.toString();
        String[] strs = factorial.split("");
        System.out.println("Product: " + product);
        System.out.println("Length of product: " + factorial.length());

        int[] ints = new int[factorial.length()];
        for (int i = 0; i < ints.length; i++) ints[i] = Integer.parseInt(strs[i]);

        int sum = 0;
        for (int digit : ints) sum += digit;
        System.out.println("Sum of all digits of product: " + sum);
    }
}
