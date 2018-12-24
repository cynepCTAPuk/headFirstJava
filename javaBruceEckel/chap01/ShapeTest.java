package chap01;

public class ShapeTest {
    public static void doSomething(Shape shape) {
        shape.erase();
        // ...
        shape.draw();
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        doSomething(circle);
        doSomething(triangle);
    }
}
