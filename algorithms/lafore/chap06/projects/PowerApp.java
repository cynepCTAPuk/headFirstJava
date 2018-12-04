package lafore.chap06.projects;

import static lafore.chap06.projects.MultApp.*;

public class PowerApp {
    static int i = 0;

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        long c = power(a, b);
        System.out.println(String.format("%,d xx %,d = %,d", a, b, c));
    }

    public static long power(long first, long second) {
        long result;
        if (second == 1) {
            System.out.println("          " + ++i + " Mult step & result" + first);
            result = first;
        } else {
//            result = first * power(first, second - 1);
            result = mult(first, power(first, second - 1));
            System.out.println("          " + ++i + " Mult step & result = " + result);
        }
        return result;
    }
}
