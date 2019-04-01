package com.javacode.lambdas.model;

public class Circle extends Ellipsis implements Shape, AnotherShape {
    public Circle() {
        System.out.println("Creating circle");
    }

    @Override
    public double calcSquare() {
        return 1;
    }
}
