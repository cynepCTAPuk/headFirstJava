import java.text.*;
import java.util.*;

public class TestFormat {

    public static void main(String[] args) throws ParseException {
        long n = 461012;
        System.out.format("%8d\n", n);      //  -->  "461012"
        System.out.format("%08d\n", n);    //  -->  "00461012"
        System.out.format("%+8d\n", n);    //  -->  " +461012"
        System.out.format("%,8d\n", n);    // -->  " 461,012"
        System.out.format("%+,8d\n\n", n); //  -->  "+461,012"

        double pi = Math.PI;

        System.out.format("%8f\n", pi);        // -->  "3.141593"
        System.out.format("%8.3f\n", pi);      // -->  "3.142"
        System.out.format("%-8.3f\n\n", pi);   // -->  "3.142"
        System.out.format(Locale.ENGLISH,
                "%-10.6f\n", pi);       // -->  "3.1416"
        System.out.format(Locale.FRANCE,
                "%-10.6f\n", pi);     // -->  "3,1416" Locale.FRANCE Locale.GERMAN
        System.out.format(new Locale("ru"),
                "%-10.6f\n\n", pi);     // -->  "3,1416" Locale.FRANCE Locale.GERMAN

        Calendar c = Calendar.getInstance();
        System.out.format("%td %tB, %tY\n", c, c, c);   // -->  "04 March, 2019"
        System.out.format(new Locale("ru"),
                "%te %tB, %tY\n", c, c, c);      // -->  "4 марта, 2019"
        System.out.format("%tl:%tM %tp\n", c, c, c);    // -->  "5:03 am"
        System.out.format("%tH:%tM\n", c, c, c);        // -->  "17:03"
        System.out.format("%tD\n", c);                  // -->  "03/04/19"
        System.out.format(new Locale("ru"),
                "%tD\n", c);                     // -->  "03/04/19"
    }
}