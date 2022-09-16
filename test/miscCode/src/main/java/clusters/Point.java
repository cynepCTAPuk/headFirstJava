package clusters;

class Point {
    private int x;
    private int y;
    private int value;

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", value=" + value + '}';
    }

    public boolean near(Point point) {
        return getX() == point.getX() && Math.abs(getY() - point.getY()) == 1 ||
                getY() == point.getY() && Math.abs(getX() - point.getX()) == 1;
    }
}
