// https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
package string;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class FormatTest {
    public static void main(String[] args) {
        long n = 461012;
        System.out.format("%10d%n", n);      //  -->  "461012"
        System.out.format("%010d%n", n);    //  -->  "00461012"
        System.out.format("%+10d%n", n);    //  -->  " +461012"
        System.out.format("%,10d%n", n);    // -->  " 461,012"
        System.out.format("%+,10d%n%n", n); //  -->  "+461,012"

        double pi = Math.PI;
        System.out.format("%10f%n", pi);                // -->  "3.141593"
        System.out.format("%10.4f%n", pi);              // -->  "3.142"
        System.out.format("%-10.4f%n", pi);             // -->  "3.142"
        Locale uk = Locale.UK;
        System.out.format(uk, "%-10f - UK%n", pi); // -->  "3.1416"
        Locale ru = new Locale("ru");
        System.out.format(ru, "%-10f - RU%n%n", pi);

        LocalDateTime localDateTime = LocalDateTime.now();
        int dayOfMonth = localDateTime.getDayOfMonth();
        Month month = localDateTime.getMonth();
        int year = localDateTime.getYear();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        String x = dayOfMonth + " " + month + " " + year + " - " + dayOfWeek;
        System.out.println(x + "\n");

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Locale us = Locale.US;
        System.out.format(us, "%td %tB, %tY%n", date, date, date);      // -->  "04 March, 2019"
        System.out.format(ru, "%te %tB, %tY%n", date, date, date);      // -->  "4 марта, 2019"
        System.out.format("%tl:%tM %tp%n", date, date, date);                  // -->  "5:03 am"
        System.out.format("%tH:%tM:%tS%n", date, date, date);                  // -->  "17:03"
        System.out.format(ru, "%tF%n", date);                           // -->  "03/04/19"
        System.out.format(us, "%tc%n", date);                           // -->  "03/04/19"
    }
}