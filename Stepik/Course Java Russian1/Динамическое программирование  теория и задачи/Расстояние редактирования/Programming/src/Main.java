import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int[][] d = editDistBU(a, b);
//    print2dArray(d);
        System.out.println(d[a.length][b.length]);

    }
    private static int[][] editDistBU(char[] a, char[] b) {
        int[][] d = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; i++) d[i][0] = i;
        for (int i = 0; i < b.length + 1; i++) d[0][i] = i;
        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                int c = (a[i - 1] != b[j - 1]) ? 1 : 0;
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + c);
            }
        }
        return d;
    }

    private static void print2dArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%3d", array[i][j]);
            }
            System.out.println();
        }
    }
}