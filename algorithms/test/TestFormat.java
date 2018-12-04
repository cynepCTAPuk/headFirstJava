package test;

import java.util.*;

public class TestFormat {

    public static void main(String[] args) {
        long n = 123456;
        double pi = Math.PI;
        Calendar calendar = Calendar.getInstance();

        System.out.format("%d%n", n);      //  -->  "461012"
        System.out.format("%08d%n", n);    //  -->  "00461012"
        System.out.format("%+8d%n", n);    //  -->  " +461012"
        System.out.format("%,8d%n", n);    // -->  " 461,012"
        System.out.format("%+,8d%n%n", n); //  -->  "+461,012"

        System.out.format("%f%n", pi);       // -->  "3.141593"
        System.out.format("%.3f%n", pi);     // -->  "3.142"
        System.out.format("%10.3f%n", pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n", pi);  // -->  "3.142"
        System.out.format(Locale.FRANCE,                "%-10.4f%n%n", pi); // -->  "3,1416"

        System.out.format("%tB %te, %tY%n", calendar, calendar, calendar); // -->  "May 29, 2006"
        System.out.format("%tl:%tM %tp%n", calendar, calendar, calendar);  // -->  "2:34 am"
        System.out.format("%tD%n", calendar);    // -->  "05/29/06"
    }
}