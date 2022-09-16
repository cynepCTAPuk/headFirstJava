package regex.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try {
            Matcher matcher = Pattern.compile("[^ ]*[ ]{1}(([^ ]*[ ]){3}[^ ]*)").matcher(string);
            String result = "";
            if (matcher.find()) result = matcher.group(1);
            return result;
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
