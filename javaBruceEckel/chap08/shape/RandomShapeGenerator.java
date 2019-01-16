package chap08.shape;

//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
import java.util.*;
public class RandomShapeGenerator {
    int size;
    public RandomShapeGenerator() {size =1; }
    public RandomShapeGenerator(int size) { this.size = size; }

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