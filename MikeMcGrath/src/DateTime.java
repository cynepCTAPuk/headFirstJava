package src;

import java.time.*;

import static java.lang.String.*;

public class DateTime {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Сейчас " + date);
        date = date.withYear(2018);
        System.out.println("Теперь текущее время " + date);

        String fields = "";
        fields += format("\n%-15s%10s", "Год:", date.getYear());
        fields += format("\n%-15s%10s", "Месяц:", date.getMonth());
        fields += format("\n%-15s%10s", "Номер месяца:", date.getMonthValue());
        fields += format("\n%-15s%10s", "День недели:", date.getDayOfWeek());
        fields += format("\n%-15s%10s", "День месяца:", date.getDayOfMonth());
        fields += format("\n%-15s%10s", "День в году:", date.getDayOfYear());
        fields += format("\n%-15s%10s", "Час (0-23):", date.getHour());
        fields += format("\n%-15s%10s", "Минута:", date.getMinute());
        fields += format("\n%-15s%10s", "Секунда:", date.getSecond());
        System.out.println(fields);
    }
}
