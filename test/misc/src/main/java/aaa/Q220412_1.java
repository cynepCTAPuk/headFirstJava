package aaa;

public class Q220412_1 {
    public static void main(String[] args) {
        final int i = 0, j = 3;
/*
        while (i < j) {
            System.out.println("H");
            j -= 1;
        }
*/
        char a = 0x13;
        System.out.println("a=" + a);
//        System.out.println(Integer.parseInt("0xF", 16));
        char b = 100;
        System.out.println(Integer.parseInt(b + "", 16));
        System.out.println("b=" + b);
    }
}

