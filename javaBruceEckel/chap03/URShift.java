package chap03;

//: operators/URShift.java
// Test of unsigned right shift.
public class URShift {
    public static void main(String[] args) {
        int i = -1;
        System.out.print("i " + Integer.toBinaryString(i) + " ");
        System.out.println(Integer.toBinaryString(i).length() + " -1");
        i >>>= 10;
        System.out.print("i " + Integer.toBinaryString(i) + " ");
        System.out.println(Integer.toBinaryString(i).length() + " i>>>=10");
        long l = -1;
        System.out.print("l " + Long.toBinaryString(l) + " ");
        System.out.println(Long.toBinaryString(l).length() + " -1");
        l >>>= 10;
        System.out.print("l " + Long.toBinaryString(l) + " ");
        System.out.println(Long.toBinaryString(l).length() + " l>>>=10");
        short s = -1;
        System.out.println("s " + Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println("s " + Integer.toBinaryString(s));
        byte b = -1;
        System.out.println("b " + Integer.toBinaryString(b));
        b >>>= 10;
        System.out.println("b " + Integer.toBinaryString(b));
        b = -1;
        System.out.println("b " + Integer.toBinaryString(b));
        System.out.println("b " + Integer.toBinaryString(b >>> 10));
    }
} /* Output:
11111111111111111111111111111111
1111111111111111111111
1111111111111111111111111111111111111111111111111111111111111111
111111111111111111111111111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
1111111111111111111111
*///:~