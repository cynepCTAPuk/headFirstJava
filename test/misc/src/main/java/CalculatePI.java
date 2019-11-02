package com.example;

import java.util.Random;

public class CalculatePI {
    public static double calcPI(int n) {
        Random random = new Random(42);
        long count = 0;
        double x, y;
        for (int i = 0; i < n; i++) {
            x = random.nextDouble();
            y = random.nextDouble();
            if (x * x + y * y < 1) count++;
        }
        double result = (double) count / (double) n;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(4 * calcPI(100_000_000));
        System.out.println(Math.PI);
    }
}
