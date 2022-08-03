package string.task3909;

import java.util.ArrayList;
import java.util.List;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        String first = "abcdef11";
        String second = "abcdef2";
        System.out.println(isOneEditAway(first, second));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        int length1 = first.length(), length2 = second.length();
        if (length1 > length2 + 1 || length2 > length1 + 1) return false;
        if (first.equals(second)) return true;

        List<Character> list1 = new ArrayList<>();
        for (char c : first.toCharArray()) list1.add(c);
        List<Character> list2 = new ArrayList<>();
        for (char c : second.toCharArray()) list2.add(c);

        if (length1 > length2) {
            for (int i = 0; i < list1.size(); i++) {
                List<Character> list = new ArrayList<>(list1);
                list.remove(i);
                if (list.equals(list2)) {
                    System.out.println("1");
                    return true;
                }
            }
        }
        if (length1 < length2) {
            for (int i = 0; i < list2.size(); i++) {
                List<Character> list = new ArrayList<>(list2);
                list.remove(i);
                if (list.equals(list1)) {
                    System.out.println("2");
                    return true;
                }
            }
        }

        if (length1 == length2) {
            int err = 0;
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) err++;
                if (err > 1) return false;
            }
            return true;
        }

        return false;
    }
}
