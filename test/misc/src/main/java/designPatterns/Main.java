package designPatterns;

public class Main {
    public static void main(String[] args) {
        TaxCalculator calculator = getCalculator();
        calculator.calculateTax();
    }

    public static TaxCalculator getCalculator() {
        return new TaxClaculator2019();
    }
}
