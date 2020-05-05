import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        int size = scanner.nextInt();
        int[] n = new int[size];
        for (int i = 0; i < size; i++) {
            n[i] = scanner.nextInt();
        }
        System.out.println(knapsackWithoutRepsBU(weight, n));
    }

    private static int knapsackWithoutRepsBU(int weight, int[] n) {
        int[][] result = new int[n.length + 1][weight + 1];

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = result[i - 1][j];
                if (n[i - 1] <= j) {
                    result[i][j] = Math.max(result[i][j], result[i - 1][j - n[i - 1]] + n[i - 1]);
                }
            }
        }
        return result[n.length][weight];
    }
}