package oop.shape;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(0, 0), 1, Color.BLACK);
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1), Color.RED);
        Square square = new Square(new Point(5, 5), 2, Color.BLUE);

        Shape shape = triangle;
        Object object = triangle;
        triangle = (Triangle) object;

        Shape[] shapes = {circle, triangle, square};
        printArrayElements(shapes);

        Shape maxShape = findShapeWithMaxArea(shapes);
        System.out.println("Shape with max area: " + maxShape);
    }

    private static void printArrayElements(Object[] objects) {
        for (Object obj : objects) System.out.println(obj);
    }

    private static Shape findShapeWithMaxArea(Shape[] shapes) {
        if (shapes == null) return null;
        Shape shape = shapes[0];
        for (Shape s : shapes) if (s.getArea() > shape.getArea()) shape = s;
        return shape;
    }
}
