package algorithms.stepik1;

/**
 * Stepic: расстояние редактирования (Левенштейна)
 * Вычислите расстояние редактирования двух данных непустых строк длины не более 10<sup>2</sup>,
 * содержащих строчные буквы латинского алфавита.<p>
 * Sample Input 1:<p>
 * ab<p>
 * ab<p>
 * Sample Output 1:<p>
 * 0<p>
 * Sample Input 2:<p>
 * short<p>
 * ports<p>
 * Sample Output 2:<p>
 * 3
 */
public class Test831 {
    public static void main(String[] args) {
        String first = "distance";
        String second = "editing";
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int[][] d = editDistBU(a, b);
        print2dArray(d);
        System.out.println(d[a.length][b.length]);
    }

    private static int[][] editDistBU(char[] a, char[] b) {
        int[][] d = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; i++) d[i][0] = i;
        for (int i = 0; i < b.length + 1; i++) d[0][i] = i;
        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                int c = (a[i - 1] == b[j - 1]) ? 0 : 1;
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + c);
            }
        }
        return d;
    }

    private static void print2dArray(int[][] array) {
        for (int[] rows : array) {
            for (int element : rows) System.out.printf("%3d", element);
            System.out.println();
        }
    }

    private static int min(int a, int b, int c) {
/*
        int min = a;
        if (min > b) min = b;
        if (min > c) min = c;
        return min;
*/
//        return a < b ? a < c ? a : c : b < c ? b : c;
        return a < b ? Math.min(a, c) : Math.min(b, c);
    }
}
