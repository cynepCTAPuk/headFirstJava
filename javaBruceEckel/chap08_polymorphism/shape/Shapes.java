package chap08_polymorphism.shape;

//: polymorphism/Shapes.java
// Polymorphism in Java.
public class Shapes {
    private static RandomShapeGenerator shape = new RandomShapeGenerator();
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        // Fill up the array with shapes:
        for(int i = 0; i < shapes.length; i++) shapes[i] = shape.next();
        // Make polymorphic method calls:
        for(Shape shp : shapes) { shp.draw(); }
    }
} /* Output:
Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()
*///:~