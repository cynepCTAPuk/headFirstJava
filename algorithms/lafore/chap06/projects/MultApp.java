package lafore.chap06.projects;

public class MultApp {
    static int i = 0;

    public static void main(String[] args) {
        int a = 11;
        int b = 9;
        long c = mult(a, b);
        System.out.println(a + " x " + b + " = " + c);
    }

    public static long mult(long first, long second) {
        long result;
        String leftAlignFormat = "| %-4d | %-10s | %-20d |%n";
        String message = "Add step".trim();
        if (second == 1) {
//            System.out.println(++i + " Add step " + first);
            System.out.format("|------Test Cases with Steps Summary ------|%n");
            System.out.format("+------+------------+----------------------+%n");
            System.out.printf(leftAlignFormat, ++i, message, first);
            result = first;
        } else {
            result = first + mult(first, second - 1);
//            System.out.println(++i + " Add step " + result);
            System.out.printf(leftAlignFormat, ++i, message, result);
        }
        return result;
    }
}
