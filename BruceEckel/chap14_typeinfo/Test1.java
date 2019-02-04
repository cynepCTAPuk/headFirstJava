package chap14_typeinfo;

import java.util.Arrays;

class Test1 {
    public static void main(String[] args) {
        int[] a = {11, 12, 13, 14};
        int[] b = {0, 1, 2, 3};
        System.out.println(a[(a = b)[3]]);
        System.out.println(Arrays.toString(a = b));
    }
}