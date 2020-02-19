package date_time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTest1 {
    public static void main(String[] args) throws Exception {
        System.out.println("-".repeat(60));
//        String string = "January 2, 2010";
//        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        String string = "2010 01 02";
        DateFormat format = new SimpleDateFormat("yyyy MM dd", Locale.ENGLISH);
        Date date = format.parse(string);
        System.out.println(date);
        System.out.println("-".repeat(60));

        Date d = new Date(2013 - 1900, 0, 0);
        System.out.println(d);
        d = new Date();
        System.out.println(d);
    }
}
