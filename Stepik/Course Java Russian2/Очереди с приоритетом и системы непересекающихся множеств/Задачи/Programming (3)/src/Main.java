import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // qty numbers
        int e = scanner.nextInt();  // qty equal
        int d = scanner.nextInt();  // qty not equal

        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int[] leftN = new int[e + d];
        int[] rightN = new int[e + d];
        for (int i = 0; i < e + d; i++) {
            leftN[i] = scanner.nextInt() - 1;
            rightN[i] = scanner.nextInt() - 1;
        }

        for (int i = 0; i < e; i++) {
            int left = leftN[i];
            int right = rightN[i];
            left = parent(left, parents);
            right = parent(right, parents);
            if (right != left) {
                parents[right] = left;
            }
            parent(rightN[i], parents);
        }
        int result = 1;
        for (int i = e; i < e + d; i++) {
            if (parents[leftN[i]] == parents[rightN[i]]) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }

    private static int parent(int i, int[] array) {
        if (i != array[i]) {
            array[i] = parent(array[i], array);
        }
        return array[i];
    }
}
