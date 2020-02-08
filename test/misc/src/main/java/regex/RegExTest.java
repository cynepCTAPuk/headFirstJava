package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

    public static void main(String[] args) {
//        String string = "aaa a aaaa aa aaa";
//        Pattern pattern = Pattern.compile("[a]+");
//        String string = "<p><b>Википедия</b> — свободная энциклопедия, в которой <i>каждый</i> может изменить или дополнить любую статью.</p>";
//        Pattern pattern = Pattern.compile("<.*?>");
//        String string = "abxaabxaa";
//        Pattern pattern = Pattern.compile("ab(xa)*+a");
        String string = "abccaxcc";
        Pattern pattern = Pattern.compile("a(bc|b|x)cc");

        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group() + " " + matcher.start() + ":" + matcher.end());
        }
    }
}
