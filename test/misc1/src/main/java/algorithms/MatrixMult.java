package algorithms;

import util.Util;

/**
 * Stepik Algorithm1: Перемножение последовательности матриц<p>
 * Вход: последовательность n матриц A<sub>1</sub>, ... , A<sub>n</sub>, которые нужно перемножить.<p>
 * Выход: порядок умножения, минимизирующий стоимость умножения.<p>
 * <p>
 * Обозначим размеры матриц A<sub>1</sub>, ... , A<sub>n</sub> через
 * m<sub>0</sub> x m<sub>1</sub>, m<sub>1</sub>, x m<sub>2</sub>, ..., m<sub>n-1</sub> x m<sub>n</sub>,
 * соответственно.<p>
 * То есть размер A<sub>i</sub> есть m<sub>i-1</sub> x m<sub>i</sub>.
 */
public class MatrixMult {
    public static void main(String[] args) {
        int[] m = {50, 20, 1, 10, 100};
        System.out.printf("%,d",matrixMultBU(m));
    }

    private static int matrixMultBU(int[] m) {
        int size = m.length;
        int[][] d = new int[size][size];
        for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) d[i][j] = 888_888_888;
        for (int i = 0; i < size; i++) d[i][i] = 0;

        for (int s = 1; s < size; s++) {
            for (int i = 1; i < size - s; i++) {
                int j = i + s;
                for (int k = i; k < j; k++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k + 1][j] + m[i - 1] * m[k] * m[j]);
//                    System.out.println((i - 1) + ":" + k + ":" + j);
//                    Util.print2dArray(d);
//                    System.out.println();
                }
            }
        }
        return d[1][size - 1];
    }
}
