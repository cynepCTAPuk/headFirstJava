package chap03;

public class Exercise10 {
    public static void main(String[] args) {
        int i1 = 0x101010;
        int i2 = 0x010101;
        System.out.format("%,10d %22s\n%,10d %22s",
                i1,Integer.toBinaryString(i1),i2,Integer.toBinaryString(i2));
    }
}
