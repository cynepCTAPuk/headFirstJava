import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word_a10n_abbreviation2 {
    public static String abbreviate(String s) {
        Pattern pattern = Pattern.compile("[a-z]{4,}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group();
            int n = group.length();
            matcher.appendReplacement(stringBuffer,
                    group.substring(0, 1) + (n - 2) + group.substring(n - 1, n));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(abbreviate("internationalization"));
        System.out.println(abbreviate("*= internationalization"));
        System.out.println(abbreviate("abc  internationalization"));
        System.out.println(abbreviate("abcd abcde"));
    }
}
