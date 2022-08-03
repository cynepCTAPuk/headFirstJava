package regex;

/**
 * https://stackoverflow.com/questions/25130788/java-string-calculator
 */
public class StringToCalc {
    public static void main(String[] args) {
        String a = "5+20-15+8";
        System.out.println(a);
        String[] operands = a.split("[0-9]+");
        String[] operations = a.split("[+-]");
        double result = Double.parseDouble(operations[0]);
        for (int i = 1; i < operations.length; i++) {
            switch (operands[i]) {
                case "+":
                    result += Integer.parseInt(operations[i]);
                    break;
                case "-":
                    result -= Integer.parseInt(operations[i]);
                    break;
                default:
                    break;
            }
        }
        System.out.println(result);
    }
}
