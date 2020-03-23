package string;

import java.text.*;
import java.util.*;

public class FormatTest {

    public static void main(String[] args) throws ParseException {
        long n = 461012;
        System.out.format("%10d\n", n);      //  -->  "461012"
        System.out.format("%010d\n", n);    //  -->  "00461012"
        System.out.format("%+10d\n", n);    //  -->  " +461012"
        System.out.format("%,10d\n", n);    // -->  " 461,012"
        System.out.format("%+,10d\n\n", n); //  -->  "+461,012"

        double pi = Math.PI;
        System.out.format("%10f\n", pi);        // -->  "3.141593"
        System.out.format("%10.4f\n", pi);      // -->  "3.142"
        System.out.format("%-10.4f\n", pi);   // -->  "3.142"
        System.out.format(Locale.ENGLISH, "%-10f - english\n", pi); // -->  "3.1416"
        System.out.format(new Locale("ru"), "%-10f - russian\n\n", pi);

        Calendar c = Calendar.getInstance();
        Locale ru = new Locale("ru");
        System.out.format("%td %tB, %tY\n", c, c, c);   // -->  "04 March, 2019"
        System.out.format(ru, "%te %tB, %tY\n", c, c, c); // -->  "4 марта, 2019"
        System.out.format("%tl:%tM %tp\n", c, c, c);    // -->  "5:03 am"
        System.out.format("%tH:%tM\n", c, c, c);        // -->  "17:03"
        System.out.format(Locale.US, "%tD\n", c);                  // -->  "03/04/19"
        System.out.format(ru, "%tD\n", c);    // -->  "03/04/19"
        System.out.println(c.getDisplayName(10,2,ru));

//        System.out.println("%s".formatted(c));
    }
}