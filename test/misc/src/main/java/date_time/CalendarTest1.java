package date_time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest1 {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);
        Date date = calendar.getTime();
//        System.out.println(date);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss:SS Z z G D F E w W");
        System.out.println(dateFormat.format(calendar.getTime()));

        dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String d1 = "21.4.2014 15:56:45";
        Date date1 = dateFormat.parse(d1);
        System.out.println(date1);
        calendar.setTime(date1);

        for (int i = 1; i < 8; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i < 8; i++) {
            int d = (i + 5) % 7 + 1;
            System.out.print(d + " ");
        }
    }
}
