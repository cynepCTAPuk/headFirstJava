package date_time.task4007;

/* 
Работа с датами
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        DateFormat formatter = new SimpleDateFormat("d.M.y H:m:s");
        Calendar calendar = Calendar.getInstance();
        boolean bDate = false, bTime = false;

        if (date.contains(" ")) {
            bDate = true;
            bTime = true;
        } else {
            if (date.contains(".")) {
                bDate = true;
                formatter = new SimpleDateFormat("d.M.y");
            }
            if (date.contains(":")) {
                formatter = new SimpleDateFormat("H:m:s");
                bTime = true;
            }
        }

        try {
            calendar.setTime(formatter.parse(date));
        } catch (ParseException e) {
            return;
        }

        if (bDate) {
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + (((calendar.get(Calendar.DAY_OF_WEEK)) + 5) % 7 + 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));

        }
        if (bTime) {
            System.out.println("AM или PM: " + calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));

        }

    }
}
