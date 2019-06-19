package com.example;

public class App {
  public static void main(String[] args) {
    hello("World");

    Square square = new Square(5);
    System.out.println("Площадь квадрата со стороной "
            + square.length + " = " + square.area());

    Rectangle rectangle = new Rectangle(5, 7);
    System.out.println("Площадь прямоугольника со сторонами "
            + rectangle.a + " и " + rectangle.b + " = " + rectangle.area());

    Point point1 = new Point(1, 1);
    Point point2 = new Point(5, 3);
    System.out.println("Длина вектора " + point2 + " = " + point2.size());
    System.out.println("Sinus вектора " + point2 + " = " + point2.sinus());
    System.out.println("Cosinus вектора " + point2 + " = " + point2.cosinus());
    System.out.println(sQ(point2.sinus()) + sQ(point2.cosinus()));

    System.out.println("Расстояние между точкой " + point1 + " и точкой " + point2 + " = " + point1.distance(point2));
  }

  public static void hello(String string) {
    System.out.println("Hello " + string + "!");
  }

  public static double sQ(double base) {
    return base * base;
  }
}