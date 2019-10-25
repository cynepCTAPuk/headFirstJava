/**
 * https://tproger.ru/articles/dynprog-starters/
 * Самый дешёвый путь
 * В каждой клетке прямоугольной таблицы N*M записано некоторое число.
 * Изначально игрок находится в левой верхней клетке.
 * За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз
 * (влево и вверх перемещаться запрещено).
 * При проходе через клетку с игрока берут столько килограммов еды,
 * какое число записано в этой клетке (еду берут также за первую и последнюю клетки его пути).
 * <p>
 * Требуется найти минимальный вес еды в килограммах, отдав которую игрок может попасть в правый нижний угол.
 */
public class CheapestWay {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        f(n, m);
    }

    static void f(int n, int m) {
        long[][] array = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = 1; // ввод стоимости клетки, для примера 1, nextInt
                if (i > 0 && j > 0) {
                    array[i][j] += Math.min(array[i - 1][j], array[i][j - 1]);
                } else {
                    if (i > 0) {
                        array[i][j] += array[i - 1][j];
                    } else if (j > 0) {
                        array[i][j] += array[i][j - 1];
                    }
                }
            }
        }
        System.out.println(array[n - 1][m - 1]);
    }
}