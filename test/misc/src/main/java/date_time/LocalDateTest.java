package date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class LocalDateTest {
    public static void main(String[] args) {
        Locale ruLocale = Locale.getDefault();
        LocalDate startJavaRush = LocalDate.of(2019, 11, 19);
        System.out.print(LocalDate.now().toEpochDay() - startJavaRush.toEpochDay() + 1
                + "-й день с начала курса JavaRush и это было " + startJavaRush + " ");
        System.out.println(startJavaRush.getDayOfWeek().getDisplayName(TextStyle.FULL, ruLocale));
        System.out.print("Сегодня " + LocalDate.now() + " и это ");
        System.out.println(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, ruLocale));
    }
}
