//: strings/Groups.java
package chap13_strings;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

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
        Map<String, Integer> map = new TreeMap<>();
        for (String s : poem) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                int key = map.get(s);
                map.put(s, ++key);
            }
        }
        print(map.size()+" ----- " +map);
    }
}