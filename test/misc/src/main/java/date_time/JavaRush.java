package date_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class JavaRush {
    public static void main(String[] args) {
        Locale ruLocale = new Locale("ru");
        String dateFormat = "yyyy, dd MMMM, EEEE ";
        LocalDate startJavaRush = LocalDate.parse("2019-11-19");
        LocalDate now = LocalDate.now();
        System.out.println("\nСегодня - "
                + LocalDate.now().format(DateTimeFormatter.ofPattern(dateFormat, ruLocale))
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        );
//        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.FULL, ruLocale));
//        System.out.print(Duration.between(startJavaRush.atStartOfDay(),
//                now.atStartOfDay()).toDays() + 1);
//        System.out.print(now.toEpochDay() - startJavaRush.toEpochDay() + 1);
//        System.out.print(Period.between(startJavaRush, now).getDays() + 1);
//        System.out.print(ChronoUnit.DAYS.between(startJavaRush, now) + 1);
        System.out.println("\t"
                + (startJavaRush.until(now, ChronoUnit.DAYS) + 1)
                + "-й день с начала прохождения курса JavaRush"
        );
        System.out.println("\t\tЭто было "
                + startJavaRush.format(DateTimeFormatter.ofPattern(dateFormat, ruLocale))
        );
    }
}
