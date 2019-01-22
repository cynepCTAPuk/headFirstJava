//: strings/SplitDemo.java
package chap13_strings;

import java.util.Arrays;
import java.util.regex.Pattern;

import static util.Print.print;
import static util.Print.printnb;

public class Exercise14 {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        print(Arrays.toString( Pattern.compile("!!").split(input)));
        // Only do the first three:
        print(Arrays.toString( Pattern.compile("!!").split(input, 3)));
        for (String s : input.split("!!")) printnb(s + " ");

    }
} /* Output:
[This, unusual use, of exclamation, points]
[This, unusual use, of exclamation!!points]
*///:~