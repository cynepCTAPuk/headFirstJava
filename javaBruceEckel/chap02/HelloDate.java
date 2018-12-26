package chap02;

//: object/HelloDate.java

import java.util.*;

/**
 * The first Thinking in Java example program.
 * Displays a string and today’s date.
 *
 * @author Bruce Eckel
 * @author www.MindView.net
 * @version 4.0
 */
public class HelloDate {
    /** Entry point to class & application.
     * @param args array of string arguments
     * @throws exceptions No exceptions thrown
     */
    public static void main(String[] args) {
        System.out.print("Hello, it's ");
        System.out.println(new Date());
    }
}
