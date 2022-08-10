package t21;

public class Q210517_1 {
    public static void main(String[] args) {
        byte b = 8;
        m(b);
        m((byte) 7);
    }

    static void m(byte b) {
        System.out.println("byte");
    }
}
