package puzzle_7;

/* Don't do this! */
public class CleverSwap2 {
    public static void main(String[] args) {
        int x = 1984;
        System.out.println("x = " + Integer.toHexString(x));
        System.out.println("x = " + Integer.toBinaryString(x));
        int y = 2001;
        System.out.println("y = " + Integer.toHexString(y));
        System.out.println("y = " + Integer.toBinaryString(y));
        System.out.println();

        x = x ^ y;
        y = y ^ x;
        x = y ^ x;
        System.out.println("x = " + x + "; y = " + y);
    }
}
