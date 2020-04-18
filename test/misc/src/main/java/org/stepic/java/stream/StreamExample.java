package org.stepic.java.stream;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class StreamExample {
    public static void main(String[] args) {
        System.out.println(factorial(11));
    }

    static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    static boolean isPalindrome(String s) {
        StringBuilder leftToRigh = new StringBuilder();

        s.chars()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .forEach(leftToRigh::appendCodePoint);

        StringBuilder rightToLeft = new StringBuilder(leftToRigh).reverse();

        return leftToRigh.toString().equals(rightToLeft.toString());
    }
}
