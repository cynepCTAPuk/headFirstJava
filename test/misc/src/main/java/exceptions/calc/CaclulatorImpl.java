package exceptions.calc;

public class CaclulatorImpl implements Calculator {
    @Override
    public double calculate(String expr) {
        // ...
        throw new CalcutaltorException("An unsupported operator found");
        // ...
    }
}
