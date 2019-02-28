package puzzle_7;

/* Rube Goldberg would approve, but don’t ever do this!
 Do not assign to the same variable more than once in a single expression.
 More generally,avoid clever programming tricks.
*/
public class CleverSwap4 {
    public static void main(String[] args) {
        int x = 1984;
        System.out.println("x = " + Integer.toHexString(x));
        System.out.println("x = " + Integer.toBinaryString(x));
        int y = 2001;
        System.out.println("y = " + Integer.toHexString(y));
        System.out.println("y = " + Integer.toBinaryString(y));
        System.out.println();

//        x ^= y ^= x ^ y;
        y = (x ^= (y ^= x)) ^ y;
        System.out.println("x = " + x + "; y = " + y);


    }
}
