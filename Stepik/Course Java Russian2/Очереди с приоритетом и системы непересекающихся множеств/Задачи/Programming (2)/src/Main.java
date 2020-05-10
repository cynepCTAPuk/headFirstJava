import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // qty tables
        int m = scanner.nextInt();  // qty queries
        int[] parent = new int[n];
        int[] sizes = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            if (size > max) max = size;
            parent[i] = i;
            sizes[i] = size;
        }
        int[] destinations = new int[m];
        int[] sources = new int[m];
        for (int i = 0; i < m; i++) {
            destinations[i] = scanner.nextInt() - 1;
            sources[i] = scanner.nextInt() - 1;
        }

        for (int i = 0; i < m; i++) {
            int destination = destinations[i];
            int source = sources[i];
            source = parent(source, parent);
            destination = parent(destination, parent);
            if (source != destination) {
                parent[source] = destination;
                int size = sizes[destination] + sizes[source];
                if (size > max) max = size;
                sizes[destination] = size;
            }
            System.out.println(max);
        }
    }

    private static int parent(int i, int[] array) {
        if (i != array[i]) {
            array[i] = parent(array[i], array);
        }
        return array[i];
    }
}
