package chap07_Exceptions.stackTrace;

import java.util.Scanner;

/**
 * A program that displays a trace feature of a recursive method call.
 *
 * @author Cay Horstmann
 * @version 1.10 2017-12-14
 */
public class StackTraceTest {
    /**
     * Computes the factorial of a number
     *
     * @param n a non-negative integer
     * @return n! = 1 * 2 * . . . * n
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
/*
        var t = new Throwable();
        var out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        String description = out.toString();
        System.out.println(description);
*/
/*
        var t = new Throwable();
        var out = t.getStackTrace();
        for (StackTraceElement e : out) System.out.println(e);
*/
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);

        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.printf("return %,d\n", r);
        return r;
    }

    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
/*
        var in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        factorial(n);
*/
    }
}
