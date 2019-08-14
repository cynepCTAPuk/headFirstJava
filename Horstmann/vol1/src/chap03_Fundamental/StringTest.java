package chap03_Fundamental;

import java.util.StringJoiner;

public class StringTest {
    public static void main(String[] args) {
        System.out.println("Java\u2122");

        String greeting = "Hello";
        System.out.println(greeting.substring(0, 3));

        System.out.println(String.join("/", "S", "M", "L", "XL"));

        String[] size = {"S", "M", "L", "XL"};
        System.out.println("[" + String.join("/", size) + "]");

        StringJoiner joinerString = new StringJoiner("/", "[", "]");
        for (String s : size) joinerString.add(s);
        System.out.println(joinerString);

        System.out.println("Java".repeat(3));

        System.out.println(greeting.substring(0, 3) + "p");

        // Do not use the == operator to test whether two strings are equal!
        greeting = "Hello"; // initialize greeting to a string
        if (greeting == "Hello") System.out.println("Hello"); // probably true
        if (greeting.substring(0, 3) == "Hel") System.out.println("Hel"); // probably false}

        // test a string is neither nor empty
        String str = "string";
        if (str != null && str.length() != 0) System.out.println("String is not null or empty");

        char ch = '\uffff';
        greeting = ch + " щавель"; // initialize greeting to a string
        System.out.println(greeting.length() + " " + greeting.codePointCount(0, greeting.length()));
        for (int i = 0; i < greeting.length(); i++) System.out.print(greeting.charAt(i));
        System.out.println();

        int index = greeting.offsetByCodePoints(2, 5);
        int cp = greeting.codePointAt(index);
        System.out.println(index + " : " + cp);
    }
}
