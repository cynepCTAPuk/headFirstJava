package regex.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        Matcher matcher = Pattern.compile(" [^ ]+").matcher(string);
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (matcher.find())
            if (++i <= 4)
                result.append(matcher.group());
        if (i < 4) throw new TooShortStringException();
        return result.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
