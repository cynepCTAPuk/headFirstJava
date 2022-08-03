package date_time.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        LocalDate first = LocalDate.parse("10.05.1966", DateTimeFormatter.ofPattern("d.M.y"));
        LocalDate second = LocalDate.now();
//        second = first.plus(23, ChronoUnit.DAYS);
        System.out.println(second + " is leap? " + isLeap(second));
        System.out.println(first + " was before? " + isBefore(first.atTime(22, 10)));
        System.out.println(LocalTime.now() + " + 20 minutes = " + addTime(LocalTime.now(), 20, ChronoUnit.MINUTES));
        System.out.println("Between " + first + " and " + second + " " + getPeriodBetween(first, second));
    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        return Period.between(
                firstDate.isBefore(secondDate) ? firstDate : secondDate,
                firstDate.isBefore(secondDate) ? secondDate : firstDate);
//        return firstDate.until(secondDate);
    }
}
