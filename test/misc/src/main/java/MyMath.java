package com.example;

import java.math.*;

public class MyMath {
    public static void main(String[] args) {
        int factor = 20;
        System.out.printf("%d! = %,d\n", factor, factorial(factor));

        long fact = 40;
        System.out.printf("%d! = %,d\n", fact, factorial(fact));

        int f = 2, r = 61;
        long pow = pow(f, r);
        System.out.printf("pow(%d, %d) = %,d", f, r, pow);
    }

    public static long factorial(int value) {
        if (value < 0) throw new IllegalArgumentException("Value must be positive");
        long result = 1;
        for (int factor = 2; factor <= value; factor++) {
            result = result * factor;
        }
        return result;
    }

    private static BigInteger factorial(long value) {
        if (value < 0) throw new IllegalArgumentException("Value must be positive");
        BigInteger result = BigInteger.ONE;
        for (int factor = 2; factor <= value; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }

    static long pow(int base, int exponent) {
        long result = 1;
        if (exponent < 0) return 0;
        for (int i = 0; i < exponent; i++) result *= base;
        return result;
    }

    static long pow(long base, long exponent) {
        long result = 1;
        if (exponent < 0) return 0;
        for (int i = 0; i < exponent; i++) result *= base;
        return result;
    }
}
