package chap03;

//: operators/Literals.java
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // Hexadecimal (lowercase)
        System.out.println("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F; // Hexadecimal (uppercase)
        System.out.println("i2: " + Integer.toBinaryString(i2));
        int i3 = 0177; // Octal (leading zero)
        System.out.println("i3: " + Integer.toBinaryString(i3));

        char ch = 0xffff; // max char hex value
        System.out.println("ch: " + Integer.toBinaryString(ch));
        byte by = 0x7f; // max byte hex value
        System.out.println("by: " + Integer.toBinaryString(by));
        short sh = 0x7fff; // max short hex value
        System.out.println("sh: " + Integer.toBinaryString(sh));

        long n1 = 200L; // long suffix
        long n2 = 200l; // long suffix (but can be confusing)
        long n3 = 200;
        System.out.format("n1: %d n2: %o n3: %x %n", n1, n2, n3);
        long n4 = 0xfff;
        long n5 = 07777;
        System.out.format("0xfff= %,5d %16s %n07777= %,4d %16s%n",
                n4, Long.toBinaryString(n4), n5, Long.toBinaryString(n5));

        float f1 = 1;
        float f2 = 2F; // float suffix
        float f3 = 3f; // float suffix
        System.out.format("f1: %f f2: %f f3: %f %n", f1, f2, f3);

        double d1 = 1;
        double d2 = 2d; // double suffix
        double d3 = 3D; // double suffix
        System.out.format("d1: %f d2: %f d3: %f %n", d1, d2, d3);
// (Hex and Octal also work with long)
    }
} /* Output:
i1: 101111
i2: 101111
i3: 1111111
c: 1111111111111111
b: 1111111
s: 111111111111111
*///:~