package web.stepik.web1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeHelper {
    public static void main(String[] args) {
        System.out.println(getTimeInMs());
        System.out.println(getPOSIX());
        System.out.println(getUserDateFull(new Locale("RU")));
    }
    public static long getTimeInMs() {
        Date date = new Date();
        return date.getTime();
    }

    public static int getPOSIX() {
        Date date = new Date();
        int millisInSecond = 1_000;
        return (int) (date.getTime() / millisInSecond);
    }

    public static String getUserDateFull(Locale locale) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return dateFormat.format(date);
    }
}
