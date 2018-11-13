package appendixB;

public class BitManipulation {
    public static void main(String[] args) {
        int x = 10;
        int y = 6;
        System.out.println("x = " + x + "\t\t(00001010)\ny = " + y + "\t\t(00000110)");
        System.out.println("~x \t=\t" + ~x + "\t(11110101)\tBitwise NOT Operator");
        System.out.println("x&y =\t" + (x & y) + "\t(00000010)\tBitwise AND Operator");
        System.out.println("x|y =\t" + (x | y) + "\t(00001110)\tBitwise OR Operator");
        System.out.println("x^y =\t" + (x ^ y) + "\t(00001100)\tBitwise XOR Operator");
        x = -11;
//        x = 100;
        System.out.println("x = " + x + "\t\t(11110101)");
        System.out.println("x<<1 = " + (x << 1) + "\t(11010100)\tLeft Shift Operator");
        System.out.println("x<<2 = " + (x << 2) + "\t(11010100)\tLeft Shift Operator");
        System.out.println("x>>2 = " + (x >> 2) + "\t(11111101)\tRight Shift Operator");
        System.out.println("x>>>2 = " + (x >>> 2) + "\t(00111101)\tUnsigned Right Shift Operator");
    }
}
