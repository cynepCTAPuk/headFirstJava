package string.javaRush.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null) return true;
        int length = s.length();
        if (length == 0 || length == 1) return true;

        s = s.toLowerCase();
        s = s.replaceAll(" ", "");

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        System.out.println(map);
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) count++;
        }
        return count < 2;
    }
}
