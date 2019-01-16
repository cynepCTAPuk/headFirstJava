package chap08.shape;

//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
import java.util.*;
public class RandomShapeGenerator {
    int qty;
    public RandomShapeGenerator() { qty = 1; }
    public RandomShapeGenerator(int qty) { this.qty = qty; }

    private Random rand = new Random();
    public Shape next() {
        switch(rand.nextInt(4)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
            case 3: return new Oval();
        }
    }
} ///:~