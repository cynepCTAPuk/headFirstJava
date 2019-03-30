package vasilievAN;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {
    public static void main(String[] args) {
        Date now = new Date();
        Date old = new Date(1_000_000_000_000L);
        System.out.println("Текущая дата и время: " + now);
        System.out.println("Еще одна дата: " + old);

        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getWeeksInWeekYear());
    }
}
