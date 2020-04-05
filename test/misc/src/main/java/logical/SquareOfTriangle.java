package logical;

import java.util.ArrayList;
import java.util.List;

public class SquareOfTriangle {
    public static void main(String[] args) {
        List<Point> triAngle = new ArrayList<>();
        triAngle.add(new Point(0, 0));
        triAngle.add(new Point(8, 3));
//        triAngle.add(new Point(4, 0));
        System.out.println(squareTriangle(triAngle));
    }

    public static double squareTriangle(List<Point> triAngle) {
        double square = 0;
        for (int i = 0; i < triAngle.size(); i++) {
            Point p1 = triAngle.get(i);
            Point p2 = triAngle.get(i == triAngle.size() - 1 ? 0 : i + 1);
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

