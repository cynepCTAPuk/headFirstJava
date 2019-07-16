import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {
    public static int longestPalindrome(final String s) {
        List<String> list = getStrings(s);
        int result = 0;
        for (String value : list) {
            int j = 0;
            int k = value.length() - 1;
            int medium = 0;
            while (k - j >= 0) {
                if (value.charAt(j) == value.charAt(k)) {
                    if (j == k) medium++;
                    else medium += 2;
                    j++;
                    k--;
                } else {
                    medium = 0;
                    break;
                }
            }
            if (medium > result) result = medium;
        }
        return result;
    }

    private static List<String> getStrings(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++) list.add(s.substring(i, j + 1));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("baa"));
        System.out.println(longestPalindrome("aab"));
        System.out.println(longestPalindrome("zyabyz"));
        System.out.println(longestPalindrome("baabcd"));
        System.out.println(longestPalindrome("baablkj12345432133d"));
    }
}