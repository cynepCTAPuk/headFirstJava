package chap03_Fundamental;

public class CastTest {
    public static void main(String[] args) {
        System.out.println((float) 123456789); // 1.23456792E8
        System.out.println((byte) 300); // 44
        int x = 4;
        x += 3.5;
        System.out.println(x); // result is 7 - equivalent is (int) (x + 3.5)
        double y = x + 1.5;
        System.out.println(y); // 8.5
    }
}
