//: strings/IntegerMatch.java
package chap13_strings;

public class Exercise7 {

    public static void main(String[] args) {
        String string = "Hello World", s1, s2;
        s1 = string + ".";
        s2 = string + "!";
        String word = "Я не хожу в школу!";
        char first = s1.charAt(0);
        char end = s1.charAt(s1.length() - 1);
        System.out.println(first + " ... " + end);

        System.out.println(s1.matches("^[A-Z].*[\\.]$"));
        System.out.println(s2.matches("^[A-Z].*!$"));
        System.out.println(word.matches("^[А-Я].*!$"));
        System.out.println(word);
        System.out.println(word.replaceAll("[а|е|и|о|у|э|я]", "*"));
    }
} /* Output:
true
true
false
true
*///:~