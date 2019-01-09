package chap08.shape;

import static util.Print.print;

//: polymorphism/shape/Triangle.java
public class Triangle extends Shape {
    public void draw() { print("Triangle.draw()"); }
    public void erase() { print("Triangle.erase()"); }
} ///:~