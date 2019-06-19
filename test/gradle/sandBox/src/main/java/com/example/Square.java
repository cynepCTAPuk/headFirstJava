package com.example;

public class Square {
  public double length;

  public Square(double length) {
    this.length = length;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double area() {
    return length * length;
  }
}
