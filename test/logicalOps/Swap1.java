package logicalOps;

public class Swap1 {
    public static void main(String[] args) {
        int x = 5, y = 7;
        System.out.println(Integer.toBinaryString(x) + " " + x);
        System.out.println(Integer.toBinaryString(y) + " " + y);
        x = x ^ y;
        System.out.println(Integer.toBinaryString(x) + " " + x);
        y = x ^ y;
        System.out.println(Integer.toBinaryString(y) + " " + y);
        x = x ^ y;
        System.out.println(Integer.toBinaryString(x) + " " + x);
    }
}
