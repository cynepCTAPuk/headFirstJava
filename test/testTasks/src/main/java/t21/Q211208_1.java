package t21;

public class Q211208_1 {

    public static void main(String[] args) {
        byte b = 5;
        doCalc(b, b);
    }

    static void doCalc(byte... a) {
        System.out.println("byte...");
    }

    static void doCalc(long a, long b) {
        System.out.println("long, long");
    }

    static void doCalc(Byte a, Byte b) {
        System.out.println("Byte, Byte");
    }
}

