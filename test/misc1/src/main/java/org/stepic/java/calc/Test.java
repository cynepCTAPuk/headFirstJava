package org.stepic.java.calc;

public class Test {
    public static double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Expected non-negative number, got " + x);
        return Math.sqrt(x);
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
/*
    try {
        throw new RuntimeException();
    } catch (Exception e) {
        StackTraceElement[] elements = e.getStackTrace();
        return elements.length > 2
                ? elements[2].getClassName() + "#" + elements[2].getMethodName()
                : null;
    }
*/
/*
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        int n = 3;
*/
        StackTraceElement[] elements = new Exception().getStackTrace();
        int n = 2;
        return elements.length > n
                ? elements[n].getClassName() + "#" + elements[n].getMethodName()
                : null;

    }

    public static void main(String[] args) {
//        System.out.println(sqrt(-1));
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
}
