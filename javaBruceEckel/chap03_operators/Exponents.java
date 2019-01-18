package chap03_operators;

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
                "expDouble1 47e47d = %,g\n" + "expDouble2 47e47  = %,g\n\n",
                expDouble1, expDouble2);

        System.out.printf("Float.MAX_VALUE: %,f\n", Float.MAX_VALUE);
        System.out.printf("in scientific notation: %.18g\n", Float.MAX_VALUE);
//        System.out.printf("Double.MAX_VALUE: %,f\n", Double.MAX_VALUE);
        System.out.printf("in scientific notation: %.18g\n\n", Double.MAX_VALUE);

        System.out.println("0x1.fffffep127: " + 0x1.fffffep127);
        float maxfloat = (1 << 31) - 1;
        float minfloat = (1 << 31);
        System.out.format("max float  = %,22f %14g\n", maxfloat, maxfloat);
        System.out.format("min float  = %,22f %14g\n", minfloat, minfloat);

        double maxdouble = (1 << 31) - 1;
        double mindouble = (1 << 31);
        System.out.format("max double = %,22f %14g\n", maxdouble, maxdouble);
        System.out.format("min double = %,22f %14g\n\n", mindouble, mindouble);

        System.out.println("Float.MAX_VALUE:  " + Float.MAX_VALUE);
        System.out.println("Float.MIN_VALUE:  " + Float.MIN_VALUE + "\n");
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
    }
} /* Output:
1.39E-43
4.7E48
*///:~