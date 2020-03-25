package date_time;
/**
 *
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class JavaRush {
    public static void main(String[] args) {
        Locale ruLocale = new Locale("ru");
        String format1 = "yyyy, dd MMMM, EEEE HH:mm";
        String format2 = "yyyy, dd MMMM, EEEE";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format1, ruLocale);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(format2, ruLocale);

        LocalDateTime startJavaRush = LocalDate.parse("2019-11-19").atStartOfDay();
        LocalDateTime now = LocalDateTime.now();
        long days = startJavaRush.until(now, ChronoUnit.DAYS);

        System.out.println("\nСегодня - " + now.format(formatter));

//        System.out.print(ChronoUnit.DAYS.between(startJavaRush, now));
        System.out.println("\t" + (days + 1) + "-й день с начала прохождения курса JavaRush");
        System.out.println("\t\tЭто было " + startJavaRush.format(formatter1));
    }
}
