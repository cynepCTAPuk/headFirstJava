package ru.otus.date_time;

import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        System.out.println("-------------------Date");
        Date d = new Date();
        System.out.println(d);              // d
        System.out.println(d.toString());   // d.toString()
        System.out.println(d.getTime());    // d.getTime()
        long time = d.getTime() + 1000;
        Date d2 = new Date(time);
        System.out.println(d2);             // d2
        System.out.println(new Date(0));    // new Date(0)

        System.out.println("-------------------Calendar");
        Calendar c = Calendar.getInstance();
//        System.out.println(c);
        System.out.println(c.getTime().getTime());  // c.getTime().getTime()
        System.out.println(c.getTime());            // c.getTime()
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        c.set(2018, 10, 10, 0, 0, 0);
        System.out.println(c.getTime());
        c.set(1313, Calendar.DECEMBER, 13);
        c.set(Calendar.HOUR_OF_DAY, 13);
        c.set(Calendar.MINUTE, 13);
        c.set(Calendar.SECOND, 13);
        System.out.println(c.getTime());
    }
}
