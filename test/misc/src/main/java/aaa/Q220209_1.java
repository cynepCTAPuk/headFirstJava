package aaa;

public class Q220209_1 {
    static byte m1() {
        final char c1 = '\u0001';
        return c1;
    }

    static byte m2(final char c2) {
        return (byte) c2;
    }

    public static void main(String[] args) {
        char c3 = '\u0003';
        System.out.println("" + m1() + m2(c3));
    }
}

