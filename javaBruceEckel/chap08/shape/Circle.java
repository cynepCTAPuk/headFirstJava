package chap08.shape;

import static util.Print.print;

//: polymorphism/shape/Circle.java
public class Circle extends Shape {
    public void draw() { print("Circle.draw()"); }
    public void erase() { print("Circle.erase()"); }
} ///:~