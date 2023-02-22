package string.javaRush.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int sum = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String sub = s.substring(i, j);
                if (unique(sub)) {
                    int length = sub.length();
                    if (length > sum) sum = length;
                }
            }
        }
        return sum;
    }

    private static boolean unique(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) return false;
            }
        }
        return true;
    }
}
