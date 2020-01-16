package regex;

import java.util.ArrayList;
import java.util.List;

/**
 * https://stackoverflow.com/questions/25130788/java-string-calculator
 */
public class StringToCalc3 {
    public static void main(String[] args) {
        String input = "5.1 + 20.2 - 11 + 1";
        char[] inputs = input.replaceAll(" ", "").toCharArray();
        String number = "";
        List<Double> numbers = new ArrayList<>();
        List<Character> operands = new ArrayList<>();

        for (int i = 0; i < inputs.length - 1; i++) {
            char current = inputs[i];
            char next = ' ';
            if (i + 1 < input.length()) next = inputs[i + 1];

            if (isOperands(current)) operands.add(current);
            if (isDigit(current)) number += current;
            if (!isDigit(next)) {
                numbers.add(Double.parseDouble(number));
                number = "";
            }
        }
        System.out.println(numbers);
        System.out.println(operands);
    }

    static boolean isDigit(char input) {
        String digits = "1234567890.";
        char[] chars = digits.toCharArray();
        for (char ch : chars) if (input == ch) return true;
        return false;
    }

    static boolean isOperands(char input) {
        String operands = "+-*/";
        char[] chars = operands.toCharArray();
        for (char ch : chars) if (input == ch) return true;
        return false;
    }
}
