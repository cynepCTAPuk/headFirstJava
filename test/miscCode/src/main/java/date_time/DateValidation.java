package date_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DateValidation {
    private static final ArrayList<SimpleDateFormat> dateFormats = null;

    static {
        dateFormats.add(new SimpleDateFormat("dd-MM-yyyy"));
        dateFormats.add(new SimpleDateFormat("dd.MM.yyyy"));
        dateFormats.add(new SimpleDateFormat("dd/MM/yyyy"));
        dateFormats.add(new SimpleDateFormat("MM-dd-yyyy"));
        dateFormats.add(new SimpleDateFormat("MM.dd.yyyy"));
        dateFormats.add(new SimpleDateFormat("MM/dd/yyyy"));
    }

    public static Date convertToDate(String input) {
        Date date = null;
        if (input == null) return null;
        for (SimpleDateFormat format : dateFormats) {
            format.setLenient(false);
            try {
                date = format.parse(input);
            } catch (ParseException e) {
                System.out.print(".");
            }
            if (date != null) {
                break;
            }
        }
        return date;
    }

    public static void main(String[] args) {
        String date1 = "1-21-2001";
        String date2 = "1/21/2001";
        System.out.println(convertToDate(date1));
        System.out.println(convertToDate(date2));

        String date3 = "2001-01-01";
        String regex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
        System.out.println(date3.matches(regex));
    }
}
