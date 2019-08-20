package chap04_Objects_Classes;

public class PalindromeChecker {
    public static void main(String[] args) {

        if (args == null || args.length < 1) {
            System.err.println("String is required!!");
            System.exit(1);
        }
        System.out.printf("The string {%s} is Palindrome!! %b %n",
                args[0], StringUtils.isPalindrome(args[0]));
    }
}

class StringUtils {
    public static boolean isPalindrome(String word) {
        return (new StringBuilder(word).reverse().toString().equalsIgnoreCase(word));
    }
}