package regex;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

/**
 * https://stackoverflow.com/questions/25130788/java-string-calculator
 */
public class StringToCalc3 {
    public static void main(String[] args) {
        String input = "5.1 + 20.2 - 11 + 1";
        input = input.replace(" ", "");
        StringBuilder number = new StringBuilder();
        List<Double> numbers = new ArrayList<>();
        List<Character> operands = new ArrayList<>();

        char current;
        char next;
        for (int i = 0; i < input.length(); i++) {
            current = input.charAt(i);
            if (i < input.length() - 1) next = input.charAt(i + 1);
            else next = ' ';

            if (isOperands(current)) operands.add(current);
            if (isDigit(current)) number.append(current);
            if (!isDigit(next)) {
                numbers.add(Double.parseDouble(number.toString()));
                number = new StringBuilder();
            }
        }
        System.out.println(numbers);
        System.out.println(operands);
    }

/*
    static boolean isDigit(char input) {
        String digits = "1234567890.";
        char[] chars = digits.toCharArray();
        for (char ch : chars) if (input == ch) return true;
        return false;
    }
*/

    static boolean isOperands(char input) {
        String operands = "+-*/";
        char[] chars = operands.toCharArray();
        for (char ch : chars) if (input == ch) return true;
        return false;
    }
}
