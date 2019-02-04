package chap04_control;

public class BinaryString {
    static final char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static void main(String[] args) {
        int number = pow(2, 0) - 1;
        for (int i = 0; i < 10; i++) {
            System.out.format("%32s ", toBinary(number));
//            System.out.format("%32s ", toOctal(number));
            System.out.format("%32s ", toHex(number));
//            System.out.format("%32s ", Integer.toBinaryString(number));
            System.out.format("%,14d\n", number);
            number += 16;

        }
    }

    public static String toBinary(int i) {
        return toUnsignedString(i, 1);
    }

    public static String toOctal(int i) {
        return toUnsignedString(i, 3);
    }

    public static String toHex(int i) {
        return toUnsignedString(i, 4);
    }

    private static String toUnsignedString(int number, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = digits[number & mask];
            number >>>= shift;
        } while (number != 0);

        return new String(buf, charPos, (32 - charPos));
    }

    static int pow(int base, int exp) {
        if (exp < 0) return -1;
        if (exp == 0) return 1;
        return pow(base, exp - 1) * base;
    }
}
