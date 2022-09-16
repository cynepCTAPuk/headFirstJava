/**
 * http://www.seostella.com/ru/article/2012/02/05/formatirovanie-daty-v-java.html
 */
package date_time;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        System.out.println("Today and Now is: " + dateFormat.format(new Date()));

        System.out.println("-".repeat(60));
        Date currentDate = new Date();
        dateFormat = new SimpleDateFormat();
        System.out.println("Constructor 1: " + dateFormat.format(currentDate));
        dateFormat = new SimpleDateFormat("dd MMMM");
        System.out.println("Constructor 2: " + dateFormat.format(currentDate));
        dateFormat = new SimpleDateFormat("dd MMMM", myDateFormatSymbols);
        System.out.println("Constructor 3: " + dateFormat.format(currentDate));
        dateFormat = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);
        System.out.println("Constructor 4: " + dateFormat.format(currentDate));

        String[] strings = {"дата", "день", "месяц", "год", "время", "час", "минуты", "секунды"};
        String[] formats = {"d MMMM YYYY H:mm:ss", "d", "MMMM", "YYYY", "H:mm:ss", "H", "mm", "ss"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(new SimpleDateFormat(formats[i]).format(Calendar.getInstance().getTime()));
        }
    }

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {
        @Override
        public String[] getMonths() {
            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
                    "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        }
    };
}
