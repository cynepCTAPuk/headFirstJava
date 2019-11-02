package com.example;

import java.time.*;
import java.time.temporal.*;

public class BirthDay {

    public static void main(String[] args) {

        LocalDate bd = LocalDate.of(1962, Month.SEPTEMBER, 10);
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.printf("Today is %s Time is %s\n", today, time);

        Period p1 = Period.between(bd, today);
        long p2 = ChronoUnit.DAYS.between(bd, today);
        System.out.printf("You are %d years, %d moths %d days old (%,d days)\n",
                p1.getYears(), p1.getMonths(), p1.getDays(), p2);

        LocalDate nextBDay = bd.withYear(today.getYear());

        // If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today))
            nextBDay = nextBDay.plusYears(1);

        p1 = Period.between(today, nextBDay);
        p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.printf("There are %d months and %d days until your next birthday (%d days)\n",
                p1.getMonths(), p1.getDays(),p2);
    }
}
