package chap10_Exeptions;

import java.util.Random;

// Handle an exception and move on
public class HandleError1 {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        int i = 0;
        Random r = new Random();
        for (i = 0; i < 1_000; i++) {
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b / c);
            } catch (ArithmeticException e) {
                System.out.println("Exception: " + e);
                a = 0; // set a to zero and continue
            }
            System.out.printf("%8d\ta: %,8d\t b: %,14d\tc: %,14d\n", i, a, b, c);
        }
    }
}
