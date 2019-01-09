package chap08.shape;

import static util.Print.*;

//: polymorphism/shape/Circle.java
public class Oval extends Shape {
    @Override public void draw() { print("Circle.draw()"); }
    @Override public void erase() { print("Circle.erase()"); }
    @Override public void fill() { print("Circle.fill"); }
} ///:~