package chap03;

//: operators/Casting.java
public class Casting {
    public static void main(String[] args) {
        int i = 200;
        System.out.println("i = " + i);
        long lng = (long) i;
        System.out.println("lng = " + lng);
        lng = i; // "Widening," so cast not really required
        System.out.println("lng = " + lng);
        long lng2 = (long) 200;
        System.out.println("lng2 = " + lng2);
        lng2 = 200;
        System.out.println("lng2 = " + lng2);
// A "narrowing conversion":
        i = (int) lng2; // Cast required
        System.out.println("i = " + i);
    }
} ///:~