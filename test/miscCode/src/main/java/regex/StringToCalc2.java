package regex;

import java.util.ArrayList;
import java.util.List;

/**
 * https://stackoverflow.com/questions/25130788/java-string-calculator
 */
public class StringToCalc2 {
    public static void main(String[] args) {
        String input = "5+20+11+1";
        StringBuilder sb = new StringBuilder();

        List<Integer> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        char[] ch = input.toCharArray();

        for (char c : ch) {
            if (c != '+') sb.append(c);
            else {
                list2.add(c);
                list1.add(Integer.valueOf(sb.toString()));
                sb.setLength(0);
            }
        }
        if (sb.length() != 0) list1.add(Integer.valueOf(sb.toString()));
        System.out.println(list1.size());
        for (Integer i : list1) System.out.println("values: " + i);
    }
}
