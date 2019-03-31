package com.javacode.lambdas.model;

import java.util.List;

public interface Shape {
    double calcSquare();

    static double calcShapesSquare(List<Shape> shapes) {
        double squareSum = 0;
        for (Shape shape : shapes) squareSum = squareSum + shape.calcSquare();
        return squareSum;
    }
}
