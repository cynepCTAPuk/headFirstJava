package chap08_polymorphism.shape;

import static util.Print.print;

//: polymorphism/shape/Triangle.java
public class Triangle extends Shape {
    @Override public void draw() { print("Triangle.draw()"); }
    @Override public void erase() { print("Triangle.erase()"); }
    @Override public void fill() { print("Triangle.fill"); }
} ///:~