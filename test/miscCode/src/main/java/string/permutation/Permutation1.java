package string.permutation;

public class Permutation1 {
    public static void main(String[] args) {
        String string = "ABC";
        int length = string.length();
        permute(string, 0, length - 1);
    }

    static void permute(String string, int left, int right) {
        if (left == right)
            System.out.println(string);
        else
            for (int i = left; i <= right; i++) {
                string = swap(string, left, i);
                permute(string, left + 1, right);
                string = swap(string, left, i);
            }
    }

    static String swap(String string, int i, int j) {
        char[] charArray = string.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
