/**
 * http://www.seostella.com/ru/article/2012/02/05/formatirovanie-daty-v-java.html
 */
package date_time;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatTest1 {
    public static void main(String[] args) throws ParseException {
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

        simpleDateFormat = new SimpleDateFormat();
        System.out.println("Constructor 1: " + simpleDateFormat.format(currentDate));
        simpleDateFormat = new SimpleDateFormat("dd MMMM");
        System.out.println("Constructor 2: " + simpleDateFormat.format(currentDate));
        simpleDateFormat = new SimpleDateFormat("dd MMMM", new Locale("RU"));
        System.out.println("Constructor 3: " + simpleDateFormat.format(currentDate));
        simpleDateFormat = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);
        System.out.println("Constructor 4: " + simpleDateFormat.format(currentDate));
        System.out.println();
        System.out.println("-".repeat(60));

        System.out.println("Today and Now is: " + simpleDateFormat.format(new Date()));
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy H:mm:ss");
        String s = "30.08.2012 16:08:13";
        Date date = simpleDateFormat.parse(s);
        System.out.println(date);
        System.out.println(new Date(0));

    }
}
