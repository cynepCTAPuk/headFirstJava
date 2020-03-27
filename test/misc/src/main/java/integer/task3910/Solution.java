package integer.task3910;

import java.util.Arrays;

/*
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3*3-1));
    }

    public static boolean isPowerOfThree(int n) {
/*
        String s = Integer.toUnsignedString(n, 3);
        System.out.println(s);
//        if (n % 3 == 0) return true;
        if (s.substring(0, 1).equals("1")) {
            char[] chars = new char[s.length() - 1];
            Arrays.fill(chars, '0');
            if (s.substring(1).equals(new String(chars))) {
                return true;
            }
        }
*/
        for (int i = 1; i <= n; i *= 3) {
            if (i == n) return true;
        }
        return false;
    }
}
