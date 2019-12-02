package date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate startJavaRush = LocalDate.of(2019, 11, 19);
        System.out.println(LocalDate.now().toEpochDay() - startJavaRush.toEpochDay() + 1);
        System.out.println(startJavaRush.getDayOfWeek().getDisplayName(TextStyle.FULL,new Locale("ru")));
        System.out.println(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL,new Locale("ru")));
    }
}
