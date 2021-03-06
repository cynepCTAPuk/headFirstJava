package com.javacode.lambdas;

import java.util.function.*;

public class LambdaScopeTest {
    double d = 0.123;

    class LambdaScopeInner {
        double d = 456.123;

        void testScope(double d) {
            Consumer<Double> result = e -> {
                System.out.println("d = " + d);
                System.out.println("e = " + e);
                System.out.println("this.d = " + this.d);
                System.out.println("LambdaScopeTest.this.d = " + LambdaScopeTest.this.d);
            };
            result.accept(789.00);
        }
    }
}
