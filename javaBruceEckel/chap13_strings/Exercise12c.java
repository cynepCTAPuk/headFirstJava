//: strings/Groups.java
package chap13_strings;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Print.print;

public class Exercise12c {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch. z";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\b[a-z]\\w+").matcher(POEM);
        Set<String> set = new TreeSet<>();
        int count = 0;
        while (m.find()) {
            count++;
            System.out.print(m.group() + "(" + (m.end() - m.start()) + ") ");
            set.add(m.group());
        }
        System.out.println("\n" + count);
        print(set);
        print(set.size());
    }
}