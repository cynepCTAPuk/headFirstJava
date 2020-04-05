package date_time.task4008;

/* 
Работа с Java 8 DateTime API
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        boolean bDate = false, bTime = false;
        String sDate = "", sTime = "";

        if (date.contains(" ")) {
            String[] s = date.split(" ");
            sDate = s[0];
            sTime = s[1];

        }
        if (date.contains(".")) {
            if (sDate.equals("")) sDate = date;
            bDate = true;
        }
        if (date.contains(":")) {
            if (sTime.equals("")) sTime = date;
            bTime = true;
        }

        if (bDate) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.y");
            LocalDate localDate = LocalDate.parse(sDate, dateFormatter);

            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + localDate.getMonth().getValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (bTime) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime localTime = LocalTime.parse(sTime, timeFormatter);

            System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }

    }
}
