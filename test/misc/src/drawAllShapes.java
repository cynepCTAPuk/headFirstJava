package src;

import java.util.ArrayList;
import java.util.Iterator;

interface Shape {
    void draw();
}

class Square implements Shape {
    private String name;
    private int size;

    public Square(int size) {
        name = "Square";
        this.size = size;
    }

    public void draw() {
        System.out.println("Drawing square " + size + " size");
    }
}

class Circle implements Shape {
    public String name;
    public int size;

    public Circle(int radius) {
        name = "Circle";
        size = radius;
    }

    public void draw() {
        System.out.println("Drawing circle " + size + " diameter");
    }

}

public class drawAllShapes {
    public static <T extends Shape> void drawShape(ArrayList<T> shapeList) {
        T shape;
        Iterator<T> shapeIterator;
        shapeIterator = shapeList.iterator();
        while (shapeIterator.hasNext()) {
            shape = shapeIterator.next();
            shape.draw();
        }
    }

    public static void main(String args[]) {
        ArrayList<Shape> shapeList = new ArrayList<>();

        shapeList.add(new Square(5));
        shapeList.add(new Circle(3));
        shapeList.add(new Square(5));
        shapeList.add(new Circle(3));
        shapeList.add(new Square(5));
        shapeList.add(new Circle(3));

        drawShape(shapeList);
    }
}