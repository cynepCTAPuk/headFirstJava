import java.time.*;
import java.time.temporal.*;

public class MyBirthDay {

    public static void main(String[] args) {

        LocalDate bd = LocalDate.of(1962, Month.SEPTEMBER, 10);
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("Today is " + today + " Time is " + time);
        System.out.printf("Today is %s Time is %s\n", today, time);

        Period p1 = Period.between(bd, today);
        long p2 = ChronoUnit.DAYS.between(bd, today);
        System.out.println("You are " +
                p1.getYears() + " years, " +
                p1.getMonths() + " months, " +
                p1.getDays() + " days old. (" + p2 + " days total)");

        LocalDate nextBDay = bd.withYear(today.getYear());

        // If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today))
            nextBDay = nextBDay.plusYears(1);

        p1 = Period.between(today, nextBDay);
        p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " +
                p1.getMonths() + " months and " +
                p1.getDays() + " days until your next birthday. (" + p2 + " - total days)");
    }
}
