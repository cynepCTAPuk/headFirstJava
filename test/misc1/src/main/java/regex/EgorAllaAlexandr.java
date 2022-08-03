package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EgorAllaAlexandr {
    public static void main(String[] args) {
        String text = "Егор Алла Александр";
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("А.+а");
        matcher = pattern.matcher(text);
        System.out.println("\tЖадный режим");
        while (matcher.find()) System.out.println(text.substring(matcher.start(), matcher.end()));

        pattern = Pattern.compile("А.++а");
        matcher = pattern.matcher(text);
        System.out.println("\tСверхжадный режим");
        while (matcher.find()) System.out.println(text.substring(matcher.start(), matcher.end()));

        pattern = Pattern.compile("А.+?а");
        matcher = pattern.matcher(text);
        System.out.println("\tЛенивый режим");
        while (matcher.find()) System.out.println(text.substring(matcher.start(), matcher.end()));
    }
}
