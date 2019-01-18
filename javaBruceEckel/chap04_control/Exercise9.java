package chap04_control;

public class Exercise9 {
    public static void main(String[] args) {
        int n = 20;
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        for (int j = 0; j < n; j++) {
            System.out.print(fibonacci[j] + " ");
        }
    }
}
