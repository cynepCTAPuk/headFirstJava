package book.chap10;

import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getCalendarType() + " "+ cal.getTime());
    }
}
