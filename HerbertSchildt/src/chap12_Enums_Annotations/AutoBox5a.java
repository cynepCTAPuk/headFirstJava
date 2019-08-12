package chap12_Enums_Annotations;

// A bad use of autoboxing/unboxing
public class AutoBox5a {
    public static void main(String[] args) {
        Double a, b, c;
        a = 10.0;
        b = 4.0;
        c = Math.sqrt(a * a + b * b);
        System.out.println("Hypotenuse is " + c);
        System.out.println("Hypotenuse is " + Math.sqrt(10.0 * 10.0 + 4.0 * 4.0));
    }
}
