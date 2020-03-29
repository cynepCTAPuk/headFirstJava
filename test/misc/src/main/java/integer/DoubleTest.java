package integer;

public class DoubleTest {
    public static void main(String[] args) {
        System.out.println(doubleExpression(0.1, 0.2, 0.3));
        double d = 1E-16;
        System.out.println(Double.MIN_NORMAL);
        System.out.printf("%1.17f%n", d);

//        System.out.println(0x0bp1);
//        System.out.println(0x0bp2);
        System.out.println(0x0bp3);

        long a = Long.MAX_VALUE;
        float b = a;
        System.out.println(a);
        System.out.println(Long.toBinaryString(a));
        System.out.printf("%1.23e",b);
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 1E-4;
    }
}
