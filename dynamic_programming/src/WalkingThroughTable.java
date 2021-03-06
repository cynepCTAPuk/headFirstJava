/**
 * В прямоугольной таблице NxM в начале игрок находится в левой верхней клетке.
 * За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз
 * (влево и вверх перемещаться запрещено).
 * Посчитайте, сколько есть способов у игрока попасть в правую нижнюю клетку.
 */
public class WalkingThroughTable {
    public static void main(String[] args) {
        int i = 15;
        int j = 15;
        long t0;

        t0 = System.nanoTime();
        System.out.println(f(i, j));
        System.out.printf("%,15d\n", System.nanoTime() - t0);

        t0 = System.nanoTime();
        System.out.println(f1(i, j));
        System.out.printf("%,15d\n", System.nanoTime() - t0);
    }

    private static int f(int i, int j) {
        if (i == 1 || j == 1) return 1;
        return f(i - 1, j) + f(i, j - 1);
    }

    private static int f1(int n, int m) {
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) array[i][0] = 1;
        for (int j = 1; j < m; j++) array[0][j] = 1;

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                array[i][j] = array[i - 1][j] + array[i][j - 1];

        return array[n - 1][m - 1];
    }
}
