import java.math.BigInteger;

/**
 * Power digit sum
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 *
 * 10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376
 * 302 - length
 * 1366 - sum of digits
 */
public class n016 {
    public static void main(String[] args) {
        BigInteger product = new BigInteger("2");
        for (int i = 0; i < 1_000-1; i++) {
            product = product.multiply(new BigInteger("2"));
        }
        String twoOneHundred = product.toString();
        String[] strs = twoOneHundred.split("");

        System.out.println(product);
        System.out.println(twoOneHundred.length());
        int[] ints = new int[twoOneHundred.length()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        System.out.println(sum);
    }
}
