package com.javacode.lambdas.model;

public class AnotherCircle implements Shape, AnotherShape {
    public AnotherCircle() {
        System.out.println("Creating anotherCircle");
    }

    @Override
    public double calcSquare() {
        return 0.9;
    }

    @Override
    public double calcSomething() {
        return AnotherShape.super.calcSomething();
    }

}
