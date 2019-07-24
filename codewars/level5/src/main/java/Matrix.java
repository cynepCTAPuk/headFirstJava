import java.util.Arrays;

public class Matrix<E> {
    private E[][] matrix;

    public Matrix(int rows, int cols) {matrix = (E[][]) new Object[rows][cols];}
    public E get(int i, int j) {
        return matrix[i - 1][j - 1];
    }
    public void set(int i, int j, E e) {
        matrix[i - 1][j - 1] = e;
    }
    public void setRow(int i, E[] ee) {
        matrix[i - 1] = ee;
    }

    public void swap(int i, int j, int k, int l) {
        E m = matrix[i - 1][j - 1];
        matrix[i - 1][j - 1] = matrix[k - 1][l - 1];
        matrix[k - 1][l - 1] = m;
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

    public String[][] toArray() {
        String[][] strings = new String[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                strings[i][j] = matrix[i][j].toString();
        return strings;
    }

    public static void main(String[] args) {
/*
        Matrix<Integer> mI = new Matrix<>(3, 3);
        mI.setRow(1, new Integer[]{2, 9, 5});
        mI.setRow(2, new Integer[]{3, 0, 8});
        mI.setRow(3, new Integer[]{6, 1, 7});
        System.out.println(mI);

        mI.set(1, 1, mI.get(1, 2) * mI.get(2, 1));
        System.out.println("\n" + mI);
        mI.set(3, 2, mI.get(3, 2) + mI.get(3, 3) / 3);
        System.out.println("\n" + mI);
*/

        Matrix<String> mS = new Matrix<>(3, 3);
        mS.setRow(1, new String[]{"a", "b", "c"});
        mS.setRow(2, new String[]{"d", "e", "f"});
        mS.setRow(3, new String[]{"g", "h", "j"});
        System.out.println("\n" + mS);

        mS.swap(1, 2, 2, 1);
        System.out.println("\n" + mS);
    }
}