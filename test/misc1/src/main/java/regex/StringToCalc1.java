package regex;

/**
 * https://stackoverflow.com/questions/25130788/java-string-calculator
 */
public class StringToCalc1 {
    public static void main(String[] args) {
        String input = "5-2+20+5+11-10";
        input = input.replace(" ", "");

        String parsedInteger = "";
        String operator = "";
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) parsedInteger += c;
            if (!Character.isDigit(c) || i == input.length() - 1) {
                int parsed = Integer.parseInt(parsedInteger);
                if (operator == "") {
                    result = parsed;
                } else {
                    if (operator.equals("+")) result += parsed;
                    else if (operator.equals("-")) result -= parsed;
                }
                parsedInteger = "";
                operator = "" + c;
            }
        }
        System.out.println("Result is " + input + ":\r\n" + result);
    }
}
