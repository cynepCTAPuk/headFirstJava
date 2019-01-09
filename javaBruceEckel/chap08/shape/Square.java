package chap08.shape;

import static util.Print.print;

//: polymorphism/shape/Square.java
public class Square extends Shape {
    public void draw() { print("Square.draw()"); }
    public void erase() { print("Square.erase()"); }
} ///:~