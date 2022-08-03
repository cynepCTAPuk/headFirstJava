package regex.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try {
            Matcher matcher = Pattern.compile(" [\\wа-яА-Я\\p{Graph}]+").matcher(string);
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (matcher.find()) {
                ++i;
                if (i <= 4) result.append(matcher.group());
            }
            if (i < 4) throw new TooShortStringException();
            return result.toString().trim();
        } catch (RuntimeException e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
//        public TooShortStringException() {
//            System.out.println("Too Short");
//        }
    }
}
