package chap05;

import java.util.*;

//: initialization/OverloadingVarargs2.java
// {CompileTimeError} (Won’t compile) 
public class Exercise19 {
    static void f(String... args) {
        System.out.println("String");
        System.out.println(Arrays.toString(args));
    }
    public static void main(String[] args) {
        f("abc", "def");
        String[] strings = {"ghj", "klm"};
        f(strings);
    }
} ///:~