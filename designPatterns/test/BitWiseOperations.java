package test;

public class BitWiseOperations {

    public static void main(String[] args) {
        int i = 0x01;
        int j = 0x10;
        int k = i | j;
        System.out.printf("i = %11s %2d\n", Integer.toBinaryString(i), i);
        System.out.printf("i = %11s %2d\n", Integer.toBinaryString(i), i);
        System.out.printf("j = %11s %2d\n", Integer.toBinaryString(j), j);
        System.out.printf("i|j = %9s %2d\n", Integer.toBinaryString(i | j), i | j);
        System.out.printf("i^j = %9s %2d\n", Integer.toBinaryString(i ^ j), i ^ j);
        System.out.printf("i&j = %9s %2d\n", Integer.toBinaryString(i & j), i & j);
        System.out.printf("(i|j)^i = %5s %2d\n", Integer.toBinaryString((i | j) ^ i), (i | j) ^ i);

    }
}

