package chap05;

import java.util.*;

public class Exercise16 {
    public static void main(String[] args) {
        String[] strings;
        strings = new String[]{"abc", "def", "ghk"};
        System.out.println(Arrays.toString(strings));

        String[] strings1 = new String[5];
        for (int i = 0; i < strings1.length; i++) {
            strings1[i] = "String " + i;
        }
        System.out.println();
        System.out.println(Arrays.toString(strings1));
    }
}
