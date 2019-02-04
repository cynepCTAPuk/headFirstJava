package chap13_strings;

import java.util.regex.*;

import static util.Print.print;

public class Exercise10 {
    public static void main(String[] args) {
        String[] regexs = {
                "^Java", "\\Breg.*", "n.w\\s+h(a|i)s",
                "yy?", "yy*", "y+", "s{2}", "S{1}", "s{1,4}"};
        String string = "Java now has regular expressions";

        for(String s : regexs) {
            print("Regular expression: \"" + s + "\"");
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(string);
            while(m.find()) {
                print("Match \"" + m.group() + "\" at " + m.start() + "-" + (m.end() - 1));
            }
        }


    }
}
