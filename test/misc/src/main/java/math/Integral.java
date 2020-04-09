package math;

import java.util.function.DoubleUnaryOperator;

public class Integral {
    public static void main(String[] args) {
        System.out.println(integrate(x -> Math.abs(x), -10, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double result = 0;
        double p = 1.0E-06;
        while (a < b) {
            result += f.applyAsDouble(a) * p;
            a += p;
        }
        return result*p;
    }
}
