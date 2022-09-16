package oop.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonInside {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        if (point == null || polygon == null ) return false;
        double square = getSquare(point, polygon);
        double squarePolygon = getSquare(polygon.get(0), polygon);
//        System.out.println(square + ":" + squarePolygon);
        return square == squarePolygon;
    }

    private static double getSquare(Point point, List<Point> polygon) {
        double square = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get(i == polygon.size() - 1 ? 0 : i + 1);
            List<Point> triangle = new ArrayList<>(Arrays.asList(p1, p2, point));
            double s = squareTriangle(triangle);
            square += s;
        }
        return square;
    }

    public static double squareTriangle(List<Point> triAngle) {
        double square = 0;
        for (int i = 0; i < triAngle.size(); i++) {
            Point p1 = triAngle.get(i);
            Point p2 = triAngle.get(i == triAngle.size() - 1 ? 0 : i + 1);
            double s = (p2.getX() - p1.getX()) * (p1.getY() + p2.getY()) / 2.0;
            square += s;
        }
        return Math.abs(square);
    }
}