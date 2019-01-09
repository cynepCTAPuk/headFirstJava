package chap08.shape;

//: polymorphism/Shapes.java
// Polymorphism in Java.
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        // Fill up the array with shapes:
        for(int i = 0; i < shapes.length; i++) shapes[i] = gen.next();
        // Make polymorphic method calls:
        for(Shape shp : shapes) {
            shp.draw();
//            shp.fill();
        }
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