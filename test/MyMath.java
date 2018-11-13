import java.math.BigInteger;
import java.text.DecimalFormat;

public class MyMath {
    public static void main(String[] args) {
        int factor = 10;
        System.out.println(factor + "! = " + insertSpaces(String.valueOf(factorial(10))));

        long fact = 20;
        System.out.println(fact + "! = " + new DecimalFormat("###,###").format(factorial(fact)));
        System.out.println(fact + "! = " + insertSpaces(String.valueOf(factorial(fact))));

        long f = 2;
        long r = 10;
        double pow = Math.pow(f, r);
        System.out.println("pow(" + f + ", " + r + ") = " + insertSpaces(String.valueOf((int) pow)));
    }

    public static long factorial(int value) {
        int result = 1;
        for (int factor = 2; factor <= value; factor++) result = result * factor;
        return result;
    }

    private static BigInteger factorial(long value) {
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
            if ((i - 1) % 3 == 0) result += " ";
        }
        return result;
    }
}
