package chap01;

public class ShapeTest {
    private static void doSomething(Shape shape) {
        shape.erase();
        // ...
        shape.draw();
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();
        doSomething(circle);
        doSomething(square);
        doSomething(triangle);
    }
}
