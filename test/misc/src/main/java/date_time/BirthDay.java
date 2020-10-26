package date_time;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Date;
import java.util.Locale;

public class BirthDay {
    public static void main(String[] args) {
        Locale ruLocale = new Locale("ru");
        String dateFormat = "yyyy, dd MMMM, EEEE ";

        LocalDate bd = LocalDate.of(1962, Month.SEPTEMBER, 10);
        LocalDate today = LocalDate.now();
        System.out.println(today);
//        LocalTime time = LocalTime.now();
//        System.out.printf("Today is %s Time is %s\n", today, time);
        System.out.println("\nToday is "
                + LocalDate.now().format(DateTimeFormatter.ofPattern(dateFormat, ruLocale))
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        );

        Period p1 = Period.between(bd, today);
        long p2 = ChronoUnit.DAYS.between(bd, today);
        System.out.printf("You are %d years, %d months, %d days old (Total is %,d days)\n",
                p1.getYears(), p1.getMonths(), p1.getDays(), p2);

        LocalDate nextBDay = bd.withYear(today.getYear());

        // If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today))
            nextBDay = nextBDay.plusYears(1);

        p1 = Period.between(today, nextBDay);
        p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.printf("There are %d months and %d days until your next birthday (%d days)\n",
                p1.getMonths(), p1.getDays(), p2);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
}
