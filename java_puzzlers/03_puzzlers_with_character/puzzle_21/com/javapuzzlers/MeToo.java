package com.javapuzzlers;

import java.io.*;

public class MeToo {
    public static void main(String[] args) {
//    System.out.println(MeToo.class.getName().replaceAll("\\.", File.separator) + ".class");
        System.out.println(MeToo.class.getName()
                .replaceAll("\\.", File.separator + "\\") + ".class");
        System.out.println(File.separator);
    }
}
