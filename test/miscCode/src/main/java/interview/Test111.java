package interview;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.math.*;

/**
 * Задача FizzBuzz.
 * Необходимо реализовать функцию:
 * на вход функция получает целое число;
 * нужно вывести в консоль слово Fizz, если число кратно трем;
 * нужно вывести в консоль слово Buzz, если число кратно пяти;
 * нужно вывести в консоль слово FizzBuzz, если число кратно трем и пяти одновременно;
 * если число не кратно ни трем, ни пяти, вывести это число.
 * Sample Input 1:
 * 3
 * Sample Output 1:
 * Fizz
 * Sample Input 2:
 * 15
 * Sample Output 2:
 * FizzBuzz
 */
public class Test111 {
    public static void main(String[] args) {
        for (int i = 1; i < 51; i++) {
            fizzBuzzPrint(i);
            System.out.print(" ");
        }
    }

    static void fizzBuzzPrint(int i) {
        String result = "";
        if (i % 3 == 0) result += "Fizz";
        if (i % 5 == 0) result += "Buzz";
        System.out.print(result.length() == 0 ? i : result);
    }
}
