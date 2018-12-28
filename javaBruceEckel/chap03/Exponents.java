package chap03;

//: operators/Exponents.java
// "e" means "10 to the power."
public class Exponents {
    public static void main(String[] args) {
// Uppercase and lowercase ‘e’ are the same:
        float expFloat = 1.39e-43f;
        System.out.println(expFloat);
        System.out.format("expFloat 1.39E-43f = %,g%n", expFloat);
        double expDouble1 = 47e47d; // ‘d’ is optional
        double expDouble2 = 47e47; // Automatically double
        System.out.println(expDouble1);
        System.out.format(
                "expDouble1 47e47d = %,g%n" +
                        "expDouble2 47e47  = %,g%n",
                expDouble1, expDouble2);
        float bigFloat = 0xfffffff;
        System.out.format("bigFloat = %f %g%n", bigFloat, bigFloat);
        double bigDouble = 0xffffffff;
        System.out.format("bigDouble = %f %g%n", bigDouble, bigDouble);
        System.out.println("Float.MAX_VALUE:  " + Float.MAX_VALUE);
        System.out.println("Float.MIN_VALUE:  " + Float.MIN_VALUE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println(Float.MAX_EXPONENT);
        System.out.println(Double.MAX_EXPONENT);
    }
} /* Output:
1.39E-43
4.7E48
*///:~