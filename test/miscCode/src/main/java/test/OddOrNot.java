package test;

public class OddOrNot {
    public static void main(String[] args) {
        long[] array = {Long.MIN_VALUE, -5, 5, Long.MAX_VALUE};
        for (long i : array) {
            System.out.print(i + " is odd?");
            System.out.println(" " + Long.toString(i, 2) + " "+ Long.toBinaryString(i));
            System.out.print(OddOrNot.methode1(i));
            System.out.println(" " + OddOrNot.methode2(i));
        }
    }

    static boolean methode1(long num) {
        return num % 2 != 0;
    }

    static boolean methode2(long num) {
        return (num & 1) != 0;
    }
}
