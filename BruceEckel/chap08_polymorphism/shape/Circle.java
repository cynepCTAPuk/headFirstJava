package chap08_polymorphism.shape;

import static util.Print.print;

//: polymorphism/shape/Circle.java
public class Circle extends Oval {
    @Override public void draw() { print("Circle.draw()"); }
    @Override public void erase() { print("Circle.erase()"); }
    @Override public void fill() { print("Circle.fill"); }
} ///:~