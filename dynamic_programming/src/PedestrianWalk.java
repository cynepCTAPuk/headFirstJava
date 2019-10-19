/**
 * В прямоугольной таблице NxM в начале игрок находится в левой верхней клетке.
 * За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз
 * (влево и вверх перемещаться запрещено).
 * Посчитайте, сколько есть способов у игрока попасть в правую нижнюю клетку.
 */
public class PedestrianWalk {
    public static void main(String[] args) {
        int i = 20;
        int j = 20;
        long t0;

        t0 = System.nanoTime();
        System.out.println(f(i, j));
        System.out.printf("%,15d\n", System.nanoTime() - t0);

    }

    private static int f(int i, int j) {
        if (i == 1 || j == 1) return 1;
        return f(i - 1, j) + f(i, j - 1);
    }
}
