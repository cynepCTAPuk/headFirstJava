package oop.shape;

public abstract class Shape {
    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

/*
    public double getArea() {
        return Double.NaN;
    }
*/
    public abstract double getArea();
}
