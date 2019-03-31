package ru.otus.date_time;

import java.time.*;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;

public class DateTimeJava8 {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDate date1 = LocalDate.now();
        LocalTime time1 = LocalTime.now();
        System.out.println(dateTime1);
        System.out.println(date1 + " " + time1);

        LocalDateTime dateTime2 = LocalDateTime.of(1111, 11, 11,
                11, 11, 11);
        LocalDate date2 = LocalDate.of(1111, 11, 11);
        LocalTime time2 = LocalTime.parse("11:11:11");
        System.out.println("\n" + dateTime2);
        System.out.println(date2 + " " + time2);

        LocalDateTime dateTime3 = dateTime2
                .plus(-1, ChronoUnit.YEARS)
                .minus(1, ChronoUnit.MONTHS)
                .plus(-1, ChronoUnit.DAYS)
                .minus(1, ChronoUnit.HOURS)
                .plus(-1, ChronoUnit.MINUTES)
                .minus(1, ChronoUnit.SECONDS);
        LocalDate date3 = date2.plus(1, ChronoUnit.YEARS);
        LocalTime time3 = time2.plus(1, ChronoUnit.HOURS);
        System.out.println("\n" + dateTime3);
        System.out.println(date3 + " " + time3);

        System.out.println("\nToday is " + dateTime1.getDayOfWeek());
        System.out.println("WeekOfDay Next Year will be "
                + dateTime1.plus(1, ChronoUnit.YEARS).getDayOfWeek());

        LocalDate dateOfVictory1 = LocalDate.of(1945, 5, 9);
        Period period1 = Period.between(dateOfVictory1, LocalDate.now());
        System.out.println("\n" + period1);
        System.out.println(period1.getYears() + " years "
                + period1.getMonths() + " months " + period1.getDays() + " days");

        LocalTime dateOfVictory2 = LocalTime.of(12, 0);
        Duration duration1 = Duration.between(dateOfVictory2, LocalTime.now());
        System.out.println("\nTime is "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                + "\n" + duration1.toMinutes() + " minutes is gone from Noon");

        LocalDateTime nowUSA = LocalDateTime.now(ZoneId.of("America/New_York"));
        LocalDateTime now = LocalDateTime.now();
        Duration duration2 = Duration.between(now, nowUSA);
        System.out.println("\n" + nowUSA + "\tUSA\n" + now + "\tRussia");
        System.out.println(duration2.toHours());
        ZonedDateTime nyTime = now.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime moscowTime = now.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println(nyTime + "\n" + moscowTime);

    }
}
