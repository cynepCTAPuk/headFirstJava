package interview;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;

/**
 * https://stepik.org/course/56704
 */
public class Test {
    public static void main(String[] args) {
/*
        for (int i = 1; i < 51; i++) {
            fizzBuzzPrint(i);
            System.out.print(" ");
        }
*/
/*
        checkPalindrom("Madam i’m ,Adam");
        checkPalindrom("Olson, in Oslof");
*/
/*
        for (int i = 0; i < 15; i++) {
            printFibonacci(i);
            System.out.print(" ");
        }
*/
/*
        calculateAndPrint(1111);
        calculateAndPrint(1211);
*/

    }

    static void checkSortArrayLength(int[] array) {

    }

    static void calculateAndPrint(int n) {
        if (n > 1000 && n < 10_000) {
            System.out.println(n / 100 % 2 == 0 ? n + 100 : n * 2);
        }
    }

    static void printFibonacci(long n) {
        long a = 0;
        long b = 1;
        long c = 0;
        for (long i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.print(a);
    }

    static void checkPalindrom(String s) {
        String a = s
                           .replaceAll(" ", "")
                           .replaceAll("\\p{Punct}", "")
                           .replaceAll("’", "");
        String b = new StringBuilder(a).reverse().toString();
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equalsIgnoreCase(b) ? "yes" : "no");
    }

    static void fizzBuzzPrint(int i) {
        String result = "";
        if (i % 3 == 0) result += "Fizz";
        if (i % 5 == 0) result += "Buzz";
        System.out.print(result.length() == 0 ? i : result);
    }
}
