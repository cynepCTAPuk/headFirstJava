package unsort;

public class RecordsTest {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println(point.x() + " " + point.y());
    }
}

record Point(int x, int y) {
}