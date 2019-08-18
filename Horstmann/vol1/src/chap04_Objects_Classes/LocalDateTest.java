package chap04_Objects_Classes;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("Today is: " + now);

        LocalDate date = LocalDate.of(2018, 6, 1);
        System.out.println("Java begin: " + date);

        System.out.println("Now until date: " + now.until(date) + "\n");

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.println(year + "/" + (month < 10 ? "0" : "") + month
                + "/" + (day < 10 ? "0" : "") + day);

        LocalDate aThousandDaysLater = date.plusDays(1_000);
        year = aThousandDaysLater.getYear();
        month = aThousandDaysLater.getMonthValue();
        day = aThousandDaysLater.getDayOfMonth();
        System.out.println(year + "/" + (month < 10 ? "0" : "") + month
                + "/" + (day < 10 ? "0" : "") + day);

        GregorianCalendar someDay = new GregorianCalendar(2018, 6, 1);
        System.out.println(someDay.get(Calendar.YEAR) + "-"
                + someDay.get(Calendar.MONTH) + "-" + someDay.get(Calendar.DAY_OF_MONTH));
        someDay.add(Calendar.DAY_OF_YEAR, 1_000);
        System.out.println(someDay.get(Calendar.YEAR) + "-"
                + someDay.get(Calendar.MONTH) + "-" + someDay.get(Calendar.DAY_OF_MONTH));
    }
}
