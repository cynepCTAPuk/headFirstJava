package lafore.chap06.projects;
/**
 * Роберт Лафоре
 * проект 6.1
 *
 *
 */

public class PowerApp {
    static int i = 0;

    public static void main(String[] args) {
        long a = 2, b = 10;
        long c = power(a, b);
        System.out.format("%d ^ %d = %,d%n", a, b, c);
    }

    public static long power(long left, long right) {
        long result;
        String alignFormat = "| %2d | %-16s | %2d ^ %-2d = %12d |%n";
        String message = "Exponentiation";
        if (right == 1) {
//            System.out.format("|------------------------------------------------|%n");
//            System.out.format("+-Step-+--Operation-------+-----Result-----------+%n");
            result = left;
//            System.out.format(alignFormat, ++index, message, left, right, result);
        } else {
            result = left * power(left, right - 1);
//            System.out.format(alignFormat, ++index, message, left, right, result);
        }
        return result;
    }
}
