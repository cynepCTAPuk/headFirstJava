package patterns.template_method;

public class Plus extends BinaryOperation {

    protected Plus(double a, double b) {
        super(a, b);
    }

    @Override
    protected double apply(double a, double b) {
        return a+b;
    }
}
