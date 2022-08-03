package integer.task3009;

/* 
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        int a;
        try {
            a = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return set;
        }
        for (int i = 2; i <= 36; i++) {
            String string = Integer.toUnsignedString(a, i);
            char[] chars = string.toCharArray();
            int length = chars.length;
            int control = 0;
            for (int j = 0; j < length / 2; j++) {
                if (chars[j] != chars[length - j - 1]) break;
                control++;
            }
            if (control == length / 2) set.add(i);
        }

        return set;
    }
}