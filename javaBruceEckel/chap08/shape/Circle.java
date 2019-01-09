package chap08.shape;

import static util.Print.print;

//: polymorphism/shape/Circle.java
public class Circle extends Shape {
    @Override public void draw() { print("Circle.draw()"); }
    @Override public void erase() { print("Circle.erase()"); }
} ///:~