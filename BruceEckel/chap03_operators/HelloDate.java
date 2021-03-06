package chap03_operators;

//: object/HelloDate.java

import java.util.*;

import static java.lang.System.out;

/**
 * The first Thinking in Java example program.
 * Displays a string and today’s date.
 *
 * @author Bruce Eckel
 * @author www.MindView.net
 * @version 4.0
 */
public class HelloDate {
    /**
     * Entry point to class & application.
     *
     * @param args array of string arguments
     * @throws exceptions No exceptions thrown
     */
    public static void main(String[] args) {
        out.print("Hello, it's: ");
        out.println(new Date());
        out.printf("Hello, it's: %s", new Date());
    }
}
/* Output: (55% match)
Hello, it’s:
Wed Oct 05 14:39:36 MDT 2005
*///:~
