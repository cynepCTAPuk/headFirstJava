package chap08.shape;

//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
import java.util.*;
public class RandomShapeGenerator {
    private Random rand = new Random(47);
    public Shape next() {
        switch(rand.nextInt(4)) {
            default:
            case 0: return new Oval();
            case 1: return new Square();
            case 2: return new Triangle();
            case 3: return new Circle();
        }
    }
} ///:~