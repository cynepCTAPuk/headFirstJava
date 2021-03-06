//: strings/Splitting.java
package chap13_strings;

public class Exercise9 {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... with... a herring!";

    public static void main(String[] args) {
        System.out.println(knights.replaceAll("[a|e|i|o|u|y|A|E|I|O|U|Y]","*"));
        System.out.println(knights.replaceAll("[aeiouyAEIOUY]","*"));
        System.out.println(knights.replaceAll("\\p{Lower}","*"));
    }
}