//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\".*\\""}
package chap13_strings;

import util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise19 {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile("class [A-Z]\\w+");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for(String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find()) {
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
}