package date_time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTest1 {
    public static void main(String[] args) throws Exception {
        System.out.println("-".repeat(60));
        String string = "January 2, 2010";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = format.parse(string);
        System.out.println(date);
    }
}
