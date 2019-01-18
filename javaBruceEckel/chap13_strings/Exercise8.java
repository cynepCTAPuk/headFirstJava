//: strings/Splitting.java
package chap13_strings;

public class Exercise8 {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... with... a herring!";

    public static void split(String regex) {
//        System.out.println( Arrays.toString(knights.split(regex)));
        String[] strings = knights.split(regex);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    public static void main(String[] args) {
        split("the|you");
    }
}