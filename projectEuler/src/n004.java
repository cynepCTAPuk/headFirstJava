/**
 * Largest palindrome product
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class n004 {
    public static void main(String[] args) {
        int n = 999;
        int product;
        int max = 0;
        for (int i = n; i > n / 2; i--) {
            for (int j = n; j > n / 2; j--) {
                product = i * j;
                if (isPalindromic(product)) {
                    if (product > max) max = product;
                    System.out.print(product + "(" + i + ":" + j + ") ");
                }
            }
        }
        System.out.println();
        System.out.println(max);
    }

    public static boolean isPalindromic(int number) {
        String str = String.valueOf(number);
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) if (chars[i] != chars[n - 1 - i]) return false;
        return true;
    }
}
