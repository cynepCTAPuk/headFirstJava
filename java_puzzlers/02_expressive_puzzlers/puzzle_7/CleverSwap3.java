package puzzle_7;

public class CleverSwap3 {
    public static void main(String[] args) {
        int x = 1984;
        System.out.println("x = " + Integer.toHexString(x));
        System.out.println("x = " + Integer.toBinaryString(x));
        int y = 2001;
        System.out.println("y = " + Integer.toHexString(y));
        System.out.println("y = " + Integer.toBinaryString(y));
        System.out.println();

//        x ^= y ^= x ^ y;
        
        // The actual behavior of x ^= y ^= x ^= y in Java
        int tmp1 = x; // First appearance of x in the expression
        int tmp2 = y; // First appearance of y
        int tmp3 = x ^ y; // Compute x ^ y
        System.out.println("x ^ y = " + tmp3 + " or " + Integer.toBinaryString(tmp3));
        x = tmp3; // Last assignment: Store x ^ y in x
        y = tmp2 ^ tmp3; // 2nd assignment: Store original x value in y
        x = tmp1 ^ y; // First assignment: Store 0 in x

        System.out.println("x = " + x + "; y = " + y);


    }
}
