package regex.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            if (string == null || string.isEmpty()) throw new TooShortStringException();
            Matcher matcher = Pattern.compile("\\t[^\\t]*").matcher(string);
            String result = "";
            int i = 0;
            while (matcher.find())
                if (++i == 1)
                    result = matcher.group();
            if (i < 2) throw new TooShortStringException();
            return result.substring(1);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
//        System.out.println(getPartOfString(""));
    }
}
