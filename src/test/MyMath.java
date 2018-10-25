package test;

import java.math.BigInteger;
import java.text.DecimalFormat;

public class MyMath {
    public static void main(String[] args) {
        long value = 20;
//        System.out.println(factorial(value)); // max is 999_999_999
        System.out.println(new DecimalFormat("###,###").format(factorial(value)));
        System.out.println(insertSpaces(String.valueOf(factorial(value))));
        double Value = Math.pow(2.5, 10);
        System.out.println(Value);
        System.out.println(insertSpaces(String.valueOf((int) Value)));
    }

/*
    public static long factorial(long value) {
        long result = 1;
        for (int factor = 2; factor <= value; factor++) result = result * factor;
        return result;
    }
*/

    public static BigInteger factorial(long value) {
        if (value < 0) throw new IllegalArgumentException("Value must be positive");
        BigInteger result = BigInteger.ONE;
        for (int factor = 2; factor <= value; factor++) result = result.multiply(BigInteger.valueOf(factor));
        return result;
    }

    public static String insertSpaces(String value) {
        String result = "";
        char[] charArray = value.toCharArray();

        for (int i = charArray.length; i > 0; i--) {
            result += charArray[charArray.length - i];
            if ((i-1) % 3 == 0) result += " ";
        }
/*
        int i = charArray.length - 1;
        for (char ch : charArray) {
            result += ch;
            if (i % 3 == 0) result += " ";
            i--;
        }
*/
        return result;
    }
}
