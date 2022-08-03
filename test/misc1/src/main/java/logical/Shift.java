package logical;

public class Shift {
    public static void main(String[] args) {
        int a = -1;
        System.out.println(a << 2);
        System.out.println();

        byte b = Byte.MAX_VALUE;
        System.out.println(b);
        System.out.println((byte) (b + 1));
        System.out.println((byte) (b >> 1));
        System.out.println();

        b = Byte.MIN_VALUE;
        System.out.println(b);
        System.out.println((byte) (b - 1));
        System.out.println((byte) (b >> 1));
    }
}
