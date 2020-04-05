package logical;

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
            int x1 = p1.x;
            int x2 = p2.x;
            int y1 = p1.y;
            int y2 = p1.y;
            double width = p2.x - p1.x;
            double height = p2.y + p1.y;
            double s = width * height;
            System.out.println(x1 + ":" + y1 + " " + x2 + ":" + y2 + " = " + s + " ");
            square += s;
        }
        return Math.abs(square) / 2;
    }
}

