//: strings/Groups.java
package chap13_strings;

import java.util.*;

import static util.Print.print;

public class Exercise12a {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        String[] poem = POEM.split("\\s|\\p{Punct}");
        print(poem.length + " ----- " + Arrays.toString(poem));
        Set<String> set = new TreeSet<>();
        for (String s : poem) {
            set.add(s);        }
        print(set.size() + " ----- " + set);
    }
}