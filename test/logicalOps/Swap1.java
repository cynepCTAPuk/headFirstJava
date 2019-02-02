package logicalOps;

public class Swap1 {
    public static void main(String[] args) {
        int a = 5, b = 7;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
