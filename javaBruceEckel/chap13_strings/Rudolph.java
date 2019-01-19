//: strings/Rudolph.java
package chap13_strings;
public class Rudolph {
    public static void main(String[] args) {
        for (String pattern : new String[]{
                "Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"}
        )
            System.out.println("Rudolph".matches(pattern));
    }
} /* Output:
true
true
true
true
*///:~