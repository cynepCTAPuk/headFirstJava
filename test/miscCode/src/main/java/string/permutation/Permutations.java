package string.permutation;

/**
 * https://www.baeldung.com/java-array-permutations
 */
public class Permutations {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        allRecursive(3, array, ' ');
    }

    public static void allRecursive(int n, String[] elements, char delimiter) {
        if (n == 1) printArray(elements, delimiter);
        else {
            for (int i = 0; i < n - 1; i++) {
                allRecursive(n - 1, elements, delimiter);
                if (n % 2 == 0) swap(elements, i, n - 1);
                else swap(elements, 0, n - 1);
            }
            allRecursive(n - 1, elements, delimiter);
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
