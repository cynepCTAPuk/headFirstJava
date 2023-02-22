package string.permutation;
/**
 *  https://www.geeksforgeeks.org/java-program-to-print-all-permutations-of-a-given-string/
 *  Java program to print all permutations of a given string.
*/
public class Permutation {
    public static void main(String[] args) {
        String string = "ABC";
        int length = string.length();
        Permutation permutation = new Permutation();
        permutation.permute(string, 0, length - 1);
    }

    /**
     * permutation function
     *
     * @param string string to calculate permutation for
     * @param left   starting index
     * @param right   end index
     */
    private void permute(String string, int left, int right) {
        if (left == right)
            System.out.println(string);
        else {
            for (int i = left; i <= right; i++) {
                string = swap(string, left, i);
                permute(string, left + 1, right);
                string = swap(string, left, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

// This code is contributed by Mihir Joshi