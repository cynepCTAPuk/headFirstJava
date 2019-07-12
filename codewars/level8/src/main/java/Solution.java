public class Solution {

    public static boolean validatePin(String pin) {
        if (pin.length() != 4) return false;
        if (pin.length() != 6) return false;

        char[] chars = pin.toCharArray();
        for (char ch : chars) {
            int j = (int) ch;
            if (j < 48 && j > 57) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 48; i <= 57 ; i++) {
            System.out.print(i+":"+(char)i + " ");
        }
    }
}