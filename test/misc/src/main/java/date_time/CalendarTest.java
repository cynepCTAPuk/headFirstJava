package date_time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
//        Calendar calendar = new GregorianCalendar(2017, 0 , 25);
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 42);
        calendar.set(Calendar.SECOND, 12);

        System.out.println(calendar.getTime());
        System.out.println("-".repeat(60));
//        calendar.add(Calendar.MONTH, -2);
        calendar.roll(Calendar.WEEK_OF_MONTH, -2);
        System.out.println(calendar.getTime());

        System.out.println("-".repeat(60));
        Calendar cannes = new GregorianCalendar(216, Calendar.AUGUST, 2);
        cannes.set(Calendar.ERA, GregorianCalendar.BC);
        System.out.println(cannes.getTime());

        DateFormat df = new SimpleDateFormat("dd MMM yyy GG");
        System.out.println(df.format(cannes.getTime()));
    }
}
