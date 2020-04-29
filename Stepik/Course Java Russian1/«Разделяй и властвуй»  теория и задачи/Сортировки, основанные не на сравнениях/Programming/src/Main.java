import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = scanner.nextInt();

        int[] B = new int[11];
        for (int i = 0; i < n; i++) {
            B[A[i]]++;
        }

        for (int i = 1; i < 11; i++) {
            B[i] = B[i] + B[i - 1];
        }

        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[B[A[i]] - 1] = A[i];
            B[A[i]]--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]+" ");
        }
    }
}