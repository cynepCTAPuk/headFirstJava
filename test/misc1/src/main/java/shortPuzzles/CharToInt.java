package shortPuzzles;

public class CharToInt {
    public static void main(String[] args) {
        String s = "0123456789";
        char[] chars = s.toCharArray();
        for (char ch : chars) System.out.println((int) ch - 48);
    }
}
