package integer;

import java.math.BigInteger;

public class BitMask1 {
    public static void main(String[] args) {
        int a = 32; //2^5 == 0010 0000
        int b = 8; //2^3 == 0000 1000
        int c = 2; //2^1 == 0000 0010

        int result = a + b + c; //32 + 8 + 2 = 42 == 0010 1010
        System.out.println(Integer.toString(result, 2));
//        System.out.println(new BigInteger(String.valueOf(321456)).toString(16));

        a = result & 32; // 0010 1010 & 0010 0000 = 0010 0000
        b = result & 8; // 0010 1010 & 0000 1000 = 0000 1000
        c = result & 2; // 0010 1010 & 0000 0010 = 0000 0010
        System.out.println(new BigInteger(String.valueOf(a)).toString(2));
        System.out.println(new BigInteger(String.valueOf(b)).toString(2));
        System.out.println(new BigInteger(String.valueOf(c)).toString(2));
        System.out.println();

        result = 0;
        System.out.println(Integer.toString(result, 2));
        result |= (1 << 6); // установить 6-й бит в 1
        System.out.println(Integer.toString(result, 2));

        result = (int) Math.pow(2, 7) - 1;
        System.out.println(Integer.toString(result, 2));
        result &= ~(1 << 5); // установить 5-й бит в 1
        System.out.println(Integer.toString(result, 2));

        c = result & (1 << 4); // прочитать значение 4-го бита
        System.out.println(Integer.toString(c, 2));

    }
}
