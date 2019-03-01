package puzzle_21.com.javapuzzlers;

import java.io.*;
import java.util.regex.*;

public class MeToo {
    public static void main(String[] args) {
//        System.out.println(MeToo.class.getName(). replaceAll("\\.", File.separator) + ".class");

        System.out.println(MeToo.class.getName().replaceAll(
                "\\.", Matcher.quoteReplacement(File.separator)) + ".class");

        System.out.println(MeToo.class.getName().replaceAll(".", File.separator) + ".class");
        System.out.println(MeToo.class.getName().replace('.', File.separatorChar) + ".class");
    }
}