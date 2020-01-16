package regex;

/**
 * https://stackoverflow.com/questions/25130788/java-string-calculator
 */
public class StringToCalc {
    public static void main(String[] args) {
        String a = "5+20-15+8";
        System.out.println(a);
        String numbers[] = a.split("[0-9]+");
        String operands[] = a.split("[+-]");
        double result = Double.parseDouble(operands[0]);
        for (int i = 1; i < operands.length; i++) {
            switch (numbers[i]) {
                case "+":
                    result += Integer.parseInt(operands[i]);
                    break;
                case "-":
                    result -= Integer.parseInt(operands[i]);
                    break;
                default:
                    break;
            }
        }
        System.out.println(result);
    }
}
