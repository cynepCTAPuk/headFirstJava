/*
  Алгоритмы-прямоугольники
  1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
  2. Различные прямоугольники не соприкасаются и не накладываются.
  3. Внутри прямоугольник весь заполнен 1.
  4. В массиве:
  4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
  4.2) a[i, j] = 0, в противном случае
  5. getRectangleCount должен возвращать количество прямоугольников.
 */
package shortPuzzles;

public class Rectangles {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        boolean[][] b = getBooleanArray(a);
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j]) {
                    byte[][] arr = findArea(a, i, j);
                }
            }
        }
        return 0;
    }

    private static byte[][] findArea(byte[][] a, int i, int j) {

        return new byte[0][];
    }

    public static boolean isRectangle(byte[][] a) {
        for (byte[] bytes : a) {
            for (byte b : bytes) if (b == 0) return false;
            System.out.println();
        }
        return true;
    }

    public static boolean[][] getBooleanArray(byte[][] a) {
        boolean[][] b = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) for (int j = 0; j < a[i].length; j++) b[i][j] = byteToBoolean(a[i][j]);
        return b;
    }

    public static void printArray(byte[][] a) {
        for (byte[] bytes : a) {
            for (byte b : bytes) System.out.print(b);
            System.out.println();
        }
    }

    public static void printArray(boolean[][] a) {
        for (boolean[] bytes : a) {
            for (boolean b : bytes) System.out.print(b ? 1 : 0);
            System.out.println();
        }
    }

    public static boolean byteToBoolean(int input) {
        if (input == 0) return false;
        return true;
    }

    public static boolean intToBooleanStrict(int input) {
        if ((input == 0) || (input == 1)) return input != 0;
        else throw new IllegalArgumentException("Input is 0 or 1 !");
    }
}
