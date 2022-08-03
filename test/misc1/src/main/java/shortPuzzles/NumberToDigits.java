package shortPuzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberToDigits {
    public static void main(String[] args) {
        Integer[] digits1 = getDigits1(12345);
        System.out.println(Arrays.toString(digits1));
        Integer[] digits2 = getDigits2(12345);
        System.out.println(Arrays.toString(digits2));
    }

    public static Integer[] getDigits1(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }

    private static void collectDigits(int num, List<Integer> digits) {
        if (num / 10 > 0) collectDigits(num / 10, digits);
        digits.add(num % 10);
    }

    public static Integer[] getDigits2(int num) {
        if (num < 0) return new Integer[0];
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        Collections.reverse(digits);
        return digits.toArray(new Integer[]{});
    }
}
