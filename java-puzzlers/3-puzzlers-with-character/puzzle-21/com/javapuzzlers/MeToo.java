package com.javapuzzlers;

public class MeToo {
    public static void main(String[] args) {
//    System.out.println(MeToo.class.getName().replaceAll("\\.", File.separator) + ".class");
        System.out.println(
                MeToo.class.getName().replaceAll("\\.", "\n") + ".class");
    }
}
