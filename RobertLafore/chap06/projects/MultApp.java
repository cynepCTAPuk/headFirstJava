package lafore.chap06.projects;
/**
 * Роберт Лафоре
 * проект 6.1
 */

public class MultApp {
    static int i = 0;

    public static void main(String[] args) {
        long a = 17, b = 11;
        long c = mult(a, b);
        System.out.format("%d x %d = %,d%n", a, b, c);
    }

    public static long mult(long left, long right) {
        long result;
        String alignFormat = "| %2d | %-16s | %2d x %2d = %-11d |%n";
        String message = "Multiplication";

        if (right == 1) {
            System.out.format("|------------------------------------------------|%n");
            System.out.format("+-Step-+--Operation-------+-----Result-----------+%n");
            result = left;
            System.out.format(alignFormat, ++i, message, left, right, result);
        } else {
            result = left + mult(left, right - 1);
            System.out.format(alignFormat, ++i, message, left, right, result);
        }
        return result;
    }
}
