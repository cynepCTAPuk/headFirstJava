package unsort;

public class RecordTest {
    public static void main(String[] args) {
        Point point = new Point(333, 444, 0);
        System.out.println(point);
    }
}

record Point(double a, double b, double c) {
    public Point {
        c = Math.sqrt(a * a + b * b);
        if (a < 0 || b < 0) throw new IllegalArgumentException("Argument can't be less zero");
    }
}