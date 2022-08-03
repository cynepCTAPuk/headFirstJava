package logical.task3006;

/**
 * a = 0000 1010
 * b = 0000 1001
 * swap a and b:
 * a = a ^ b;
 * b = a ^ b;
 * a = a ^ b;
 * Определяем исключающую маску - общее значение, состоящее из уникальных (неповторяемых) битов.
 * 1. a = 0000 1010 ^ 0000 1001 = 0000 0011
 * Маскируем биты b, позволяя выделить биты a.
 * 2. b = 0000 1001 ^ 0000 0011 = 0000 1010
 * Маскируем биты a, позволяя выделить биты b.
 * 3. a = 0000 0011 ^ 0000 1010 = 0000 1001
 */

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }
}
