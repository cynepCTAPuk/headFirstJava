import java.util.Arrays;

public class MatrixString<E> {
    String[][] matrix;

    public MatrixString(int rows, int cols) {
        this.matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = "";
    }

    public String get(int i, int j) {
        return matrix[i - 1][j - 1];
    }

    public void set(int i, int j, String string) {
        matrix[i - 1][j - 1] = string;
    }

    public void setRow(int i, String[] strings) {
        matrix[i - 1] = strings;
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
        MatrixString<String> mString = new MatrixString<>(3, 3);
        mString.setRow(1, new String[]{"2", "9", "5"});
        mString.setRow(2, new String[]{"3", "0", "8"});
        mString.setRow(3, new String[]{"6", "1", "7"});
        System.out.println(mString);
        System.out.println(mString.get(2, 3));
        mString.set(2, 3, "-4");
        System.out.println(mString.get(2, 3));
    }
}