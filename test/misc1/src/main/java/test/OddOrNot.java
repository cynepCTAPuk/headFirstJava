package test;

public class OddOrNot {
    public static void main(String[] args) {
        int i = -5;
        System.out.println(i + " is odd?");
        System.out.println(OddOrNot.methode1(i));
        System.out.println(OddOrNot.methode2(i));

    }

    static boolean methode1(int num) {
        return num % 2 == 1;
    }

    static boolean methode2(int num) {
        return (num & 1) != 0;
    }
}
