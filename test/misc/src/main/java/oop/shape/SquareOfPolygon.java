package oop.shape;

import java.util.ArrayList;
import java.util.List;

public class SquareOfPolygon {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, -1));
        polygon.add(new Point(0, 9));
        polygon.add(new Point(10, 9));
        polygon.add(new Point(10, -1));
        System.out.println(squarePolygon(polygon));
    }

    public static double squarePolygon(List<Point> polygon) {
        double square = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get(i == polygon.size() - 1 ? 0 : i + 1);
            double x1 = p1.getX();
            double x2 = p2.getX();
            double y1 = p1.getY();
            double y2 = p2.getY();
            double width = p2.getX() - p1.getX();
            double height = p2.getY() + p1.getY();
            double s = width * height;
            System.out.println(x1 + ":" + y1 + " " + x2 + ":" + y2 + " = " + s + " ");
            square += s;
        }
        return Math.abs(square) / 2;
    }
}

