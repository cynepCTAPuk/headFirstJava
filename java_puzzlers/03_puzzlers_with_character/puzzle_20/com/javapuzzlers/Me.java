package puzzle_20.com.javapuzzlers;

import java.util.regex.*;

public class Me {
    public static void main(String[] args) {
        System.out.println(Me.class.getName().replaceAll(
                ".", "/") + ".class");

        System.out.println(Me.class.getName().replaceAll(
                "\\.", "/") + ".class");
        System.out.println(Me.class.getName().replaceAll(
                Pattern.quote("."), "/") + ".class");
    }
}