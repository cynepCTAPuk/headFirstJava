package regex.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber==null) return false;
        Pattern pattern = Pattern.compile(
                "(?:\\+\\d{2})?\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2}"
//                        + "(^\\+\\d{12}$)|"
//                        + "(^\\+\\(\\d{3}\\)[\\d]{12}+$)|"
//                        + "(^\\+\\d*\\(\\d{3}\\)\\d+$)|"
//                        + "(\\+[\\d-]{13}\\d)|"
//                        + "([\\d-]{10}\\d)"
        );
        Matcher matcher = pattern.matcher(telNumber);
        while (matcher.find()) {
//            System.out.println(matcher.group() + " " + matcher.start() + ":" + matcher.end());
        }
//        System.out.println("matcher.matches(): " + matcher.matches());
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] string = {
                "+380501234567",
                "+38(050)1234567",
                "+38050123-45-67",
                "050123-4567",
                "+38)050(1234567",
                "+38(050)1-23-45-6-7",
                "050ххх4567",
                "050123456",
                "(0)501234567",
        };
        for (String s : string)
            System.out.println(s + " - " + checkTelNumber(s));
    }
}
