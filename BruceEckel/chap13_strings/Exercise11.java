package chap13_strings;
import java.util.regex.*;
import static util.Print.*;

public class Exercise11 {
    public static void main(String[] args) {
        String string = "Arline ate eight apples and one orange while Anita hadn’t any";
        print(string);
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);

        while(m.find()) {
            print("Match \"" + m.group() + "\" at " + m.start() + "-" + (m.end() - 1));
        }
//        print(m.group());
    }
}

