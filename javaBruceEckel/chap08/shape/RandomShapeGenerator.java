package chap08.shape;

//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
import java.util.*;
public class RandomShapeGenerator implements Iterator<Shape>{
    int idx = -1;
    int qty;
    public RandomShapeGenerator() { qty = 1; idx++; }
    public RandomShapeGenerator(int qty) { this.qty = qty; }
    private Random rand = new Random();
    public boolean hasNext() { return ( idx < qty ); }
    public Shape next() {
        idx++;
        switch(rand.nextInt(4)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
            case 3: return new Oval();
        }
    }
    public static void main(String[] args) {
        RandomShapeGenerator shapeGenerator = new RandomShapeGenerator(3);
        System.out.println(shapeGenerator.next().fill());
    }
} ///:~