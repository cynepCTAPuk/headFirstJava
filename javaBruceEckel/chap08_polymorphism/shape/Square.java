package chap08_polymorphism.shape;

import static util.Print.print;

//: polymorphism/shape/Square.java
public class Square extends Shape {
    @Override public void draw() { print("Square.draw()"); }
    @Override public void erase() { print("Square.erase()"); }
    @Override public void fill() { print("Square.fill"); }
} ///:~