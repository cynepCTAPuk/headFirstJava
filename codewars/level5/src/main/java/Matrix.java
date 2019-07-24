import java.util.Arrays;

public class Matrix<E> {
    Integer[][] matrix;

    public Matrix(int rows, int cols) {
        this.matrix = new Integer[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = 0;
    }

    public Integer get(int i, int j) {
        return matrix[i - 1][j - 1];
    }

    public void set(int i, int j, Integer v) {
        matrix[i - 1][j - 1] = v;
    }

    public void setRow(int i, Integer[] integers) {
        matrix[i - 1] = integers;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < matrix.length; i++) {
            string += Arrays.toString(matrix[i]);
            string += i < matrix.length - 1 ? "\n" : "";
        }
        return string;
    }
// TODO: Add get, set, setRow, swap and toArray

    public static void main(String[] args) {
        Matrix<Integer> m = new Matrix<>(3, 3);
        m.setRow(1, new Integer[]{2, 9, 5});
        m.setRow(2, new Integer[]{3, 0, 8});
        m.setRow(3, new Integer[]{6, 1, 7});
        System.out.println(m);
        System.out.println(m.get(2, 3).intValue());
        m.set(2, 3, -4);
        System.out.println(m.get(2, 3).intValue());
    }
}