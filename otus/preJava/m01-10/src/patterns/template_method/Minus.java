package patterns.template_method;

public class Minus extends BinaryOperation {
    protected Minus(double a, double b) {
        super(a, b);
    }

    @Override
    protected double apply(double a, double b) {
        return a-b;
    }
}
