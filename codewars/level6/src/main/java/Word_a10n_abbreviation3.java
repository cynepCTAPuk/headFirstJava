import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word_a10n_abbreviation3 {
    public static String abbreviate(String string) {
        Pattern pattern = Pattern.compile("([a-zA-Z]{4,})");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String part = matcher.group();
            int n = part.length();
            String repl = "" + part.charAt(0) + (n - 2) + part.charAt(n - 1);
            string = string.replaceFirst(part, repl);
        }
        return string;
    }

    public static void main(String[] args) {
        System.out.println(abbreviate("internationalization"));
        System.out.println(abbreviate("*= internationalization"));
        System.out.println(abbreviate("abc  internationalization"));
        System.out.println(abbreviate("abcd abcde"));
    }
}
