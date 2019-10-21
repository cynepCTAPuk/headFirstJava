public class LongestPalindrome_1 {
    public static void main(String[] args) {
        String s = "HowManyDifferentWaysToSayAbracadacarba".toLowerCase();
//        String s = "ABACCABABB";
        f(s);
    }

    static void f(String word) {
        int n = word.length();
        int maxLength = 0;
        String maxPalindrome = "";

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                String str = word.substring(i, j + 1);
                if (isPalindrome(str)) {
                    if (str.length() > maxLength) {
                        maxLength = str.length();
                        maxPalindrome = str;
                    }
                    break;
                }
            }
        }

        System.out.println(maxPalindrome);
        System.out.println(maxLength);
    }

    static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n / 2); ++i)
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        return true;
    }
}
