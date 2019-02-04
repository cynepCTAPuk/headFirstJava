package chap08_polymorphism.shape;

import static util.Print.*;

//: polymorphism/shape/Oval.java
public class Oval extends Shape {
    @Override public void draw() { print("Oval.draw()"); }
    @Override public void erase() { print("Oval.erase()"); }
    @Override public void fill() { print("Oval.fill"); }
} ///:~