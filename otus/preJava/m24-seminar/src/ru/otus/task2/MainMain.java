package ru.otus.task2;

import java.util.Arrays;

public class MainMain {
    public static void main(String[] args) {
//        test1();
//        test1(new int[]{1, 2, 3});
//        test1(4, 5, 6);
//        test1(new int[]{7, 8, 9});
//        test2();
//        test2(args);
//        test2(new String[]{"a", "b", "c"});
        test4(args);
        test4(new String[]{"d", "e", "f"});
    }

    private static void test1(int... a) {
//        int[] b = a;
        System.out.print("test1\t" + a + "\t");
        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
    }

    private static void test2(int[] a) {
//        int[] b = a;
        System.out.print("test1\t" + a + "\t");
        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
    }

    private static void test3(final String... a) {
        System.out.print("test2\t" + a + "\t");
        System.out.println(Arrays.toString(a));
    }

    private static void test4(String[] a) {
        System.out.print("test4\t" + a + "\t");
        System.out.println(Arrays.toString(a));
        a = new String[5];
        System.out.print("test4\t" + a + "\t");
        System.out.println(Arrays.toString(a));
    }
}
