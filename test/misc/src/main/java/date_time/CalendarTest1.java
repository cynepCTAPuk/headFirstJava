package date_time;

import patterns.strategy.task3310.strategy.Entry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarTest1 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Date date = calendar.getTime();
        System.out.println(date);
        DateFormat format = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss:SS Z z G D F E w W");
        System.out.println(format.format(calendar.getTime()));
    }
}
