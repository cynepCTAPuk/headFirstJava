package lambda;

public class Calculator {
    private interface IntegerMath {
        int operation(int a, int b);
    }

    private int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {
        Calculator myApp = new Calculator();

        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        IntegerMath multiply = (a, b) -> a * b;
        IntegerMath divide = (a, b) -> a / b;

        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
        System.out.println("5 * 7 = " + myApp.operateBinary(5, 7, multiply));
        System.out.println("99 - 11 = " + myApp.operateBinary(99, 11, divide));
    }
}