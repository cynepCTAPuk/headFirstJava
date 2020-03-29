package integer;

public class IntegerTest {
    public static void main(String[] args) {
        int i = -(1 << 10);
        System.out.println(isPowerOfTwo(i));
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        // you implementation here
//        return Integer.bitCount(value < 0 ? -value : value) == 1;
/*
        value = (value < 0) ? -value : value;
        return (Integer.numberOfLeadingZeros(value) + Integer.numberOfTrailingZeros(value) == 31);
*/
        value = (value < 0) ? -value : value;
        System.out.println(Integer.toBinaryString(value));
        System.out.println(Integer.toBinaryString(~value));
        return (value != 0) && (value == (value & (~value + 1)));
    }
}
