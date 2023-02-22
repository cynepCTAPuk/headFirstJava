package string.javaRush.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
//        String query = "level22.lesson13.task01";
//        String delimiter = ".";
//        System.out.println(Arrays.toString(getTokens(query, delimiter)));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<>();
        while (stringTokenizer.hasMoreElements()) {
            list.add(stringTokenizer.nextToken());
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
