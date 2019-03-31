package beginning.binaryPrint;

public class PrintBinary {
    public static void print(long value, int size) {
        for (int i = size - 1; i >= 0; i--) {
            long mask = 1 << i;
            long result = (mask & value) >> i;
            System.out.print(result);
        }
        System.out.print(" = " + value);
//        System.out.println();
        System.out.println(value + " = " + Long.toBinaryString(value));
    }
}
