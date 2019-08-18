package chap04_Objects_Classes;

import java.time.LocalDate;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate date = LocalDate.of(1966, 5, 1);
        System.out.println(date);

        System.out.println("Now until " + now.until(date));

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.println(year + "/"
                + (month < 10 ? "0" : "") + month + "/"
                + (day < 10 ? "0" : "") + day);
    }
}
