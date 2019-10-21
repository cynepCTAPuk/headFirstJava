import java.util.Arrays;

/**
 * https://habr.com/ru/post/113108/
 * Дана строка из заглавных букв латинского алфавита.
 * Необходимо найти длину наибольшего палиндрома,
 * который можно получить вычеркиванием некоторых букв из данной строки.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
//        String s = "HowManyDifferentWays".toLowerCase();
        String s = "ABACCABABB";
        f(s);
    }

    static void f(String word) {
        int n = word.length();
        String[][] strings = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strings[i][j] = "";
            }
        }
        int max = 0;
        String maxPalindrome = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                strings[i][j] = word.substring(i, j + 1);
                char[] chars = strings[i][j].toCharArray();
                int m = 0;
                while (m < n / 2) {
                    if (chars.length > m && chars[m] != chars[chars.length - 1 - m]) {
                        strings[i][j] = "";
                    }
                    m++;
                }
                if (strings[i][j].length() > max) {
                    max = chars.length;
                    maxPalindrome = strings[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) System.out.println(Arrays.toString(strings[i]));
        System.out.println(maxPalindrome);
        System.out.println(max);
    }
}
