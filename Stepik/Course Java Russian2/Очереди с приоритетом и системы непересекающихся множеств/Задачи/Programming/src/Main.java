import java.util.Scanner;

class Main {
    static int count = 0;
    static StringBuilder change = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        buildHeap(array);
        System.out.println(count);
        if (change.length() > 0) System.out.println(change);
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(i, array, array.length);
        }
    }

    private static void siftDown(int i, int[] array, int size) {
        int minIndex = i;
        int l = 2 * i + 1;
        if (l < size && array[l] < array[minIndex]) minIndex = l;
        int r = 2 * i + 2;
        if (r < size && array[r] < array[minIndex]) minIndex = r;
        if (i != minIndex) {
            swap(i, minIndex, array);
            siftDown(minIndex, array, size);
        }
    }

    private static void swap(int i, int j, int[] array) {
        change.append(i).append(' ').append(j).append('\n');
        count++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
