package patterns.template_method;

public abstract class BinaryOperation {
    private final double a, b;

    protected BinaryOperation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double getResult() {
        return apply(a, b);
    }

    protected abstract double apply(double a, double b);
}
