package string.permutation;

/**
 * https://www.baeldung.com/java-array-permutations
 */
public class Permutations1 {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        allRecursive(array, ' ');
    }

    public static void allRecursive(String[] elements, char delimiter) {
        int n = elements.length;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) indexes[i] = 0;

        printArray(elements, delimiter);
        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                if (i % 2 == 0) swap(elements, 0, i);
                else swap(elements, indexes[i], i);
                printArray(elements, delimiter);
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
    }

    static void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    static void printArray(String[] input, char delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String s : input) sb.append(delimiter).append(s);
        System.out.println(sb.substring(1));
    }
}
