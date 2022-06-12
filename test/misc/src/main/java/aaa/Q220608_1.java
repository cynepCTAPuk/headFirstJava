package aaa;

import java.util.Arrays;

public class Q220608_1 {
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < 100; a[i] = i % 2, i++);
        System.out.println(Arrays.toString(a));
    }
}