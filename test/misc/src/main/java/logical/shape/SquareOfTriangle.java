package logical.shape;

import java.util.ArrayList;
import java.util.List;

public class SquareOfTriangle {
    public static void main(String[] args) {
        List<Point> triangle = new ArrayList<>();
        triangle.add(new Point(0, 0));
        triangle.add(new Point(8, 3));
        triangle.add(new Point(4, 0));
        System.out.println(squareTriangle(triangle));
    }

    public static double squareTriangle(List<Point> triangle) {
        double square = 0;
        for (int i = 0; i < triangle.size(); i++) {
            Point p1 = triangle.get(i);
            Point p2 = triangle.get(i == triangle.size() - 1 ? 0 : i + 1);
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

