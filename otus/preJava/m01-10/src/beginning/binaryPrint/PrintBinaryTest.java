package beginning.binaryPrint;

public class PrintBinaryTest {
    public static void main(String[] args) {
        int s1 = 1 << 32 - 1;
        int s2 = -5;
        int n = 5;

        for (int i = s1; i < s1 + n; i++) {
            new PrintBinary().print(i, 32);
            System.out.println();
        }

        for (int i = s2; i < s2 + n; i++) {
            new PrintBinary().print(i, 32);
            System.out.print("\n ");
            new PrintBinary().print(~i + 1, 32);
            System.out.println();
        }
    }
}
