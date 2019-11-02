package com.example.point;

class Point {
    private int x;
    private int y;
    private int value;

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" + "x=" + x + ", y=" + y + ", value=" + value + '}';
    }
}
