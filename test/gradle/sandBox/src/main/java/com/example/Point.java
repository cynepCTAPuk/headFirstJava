package com.example;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + '}';
  }


  public double distance(Point point) {
    return Math.sqrt((point.x - this.x) * (point.x - this.x) + (point.y - this.y) * (point.y - this.y));
  }

  public double size() {
    return distance(new Point(0, 0));
  }

  public double sinus() {
    return this.y / size();
  }

  public double cosinus() {
    return this.x / size();
  }
}
