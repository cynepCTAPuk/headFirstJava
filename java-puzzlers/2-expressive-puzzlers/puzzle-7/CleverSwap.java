public class CleverSwap {
    public static void main(String[] args) {
        int x = 1984;
        System.out.format("%14s%n", Integer.toBinaryString(x));
        int y = 2001;
        System.out.format("%14s%n", Integer.toBinaryString(y));
        System.out.println();
//        int a = x ^= y;
//        int b = x ^= y ^= x;
//        int c = x ^= y ^= x ^= y;
//        System.out.format("%14s %d%n", Integer.toBinaryString(a), a);
//        System.out.format("%14s %d%n", Integer.toBinaryString(b), b);
//        System.out.format("%14s %d%n", Integer.toBinaryString(c), c);
        System.out.format("%14s%n", Integer.toBinaryString(x ^= y));
        System.out.format("%14s%n", Integer.toBinaryString(y ^= x ^= y));
        System.out.format("%14s%n", Integer.toBinaryString(x ^= y ^= x ^= y));
//        x ^= y ^= x ^= y;
        System.out.println("x = " + x + ";\ny = " + y);
    }
}
