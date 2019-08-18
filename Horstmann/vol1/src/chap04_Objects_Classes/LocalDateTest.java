package chap04_Objects_Classes;

import java.time.LocalDate;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate date = LocalDate.of(1986, 5, 20);
        System.out.println(date);

        System.out.println("Now until date: " + now.until(date));

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.println(year + "/" + (month < 10 ? "0" : "") + month
                + "/" + (day < 10 ? "0" : "") + day);

        LocalDate aThousandDaysLater = date.plusDays(1_000);
        year = aThousandDaysLater.getYear();
        month = aThousandDaysLater.getMonthValue();
        day = aThousandDaysLater.getDayOfMonth();
        System.out.println(year + "/" + (month < 10 ? "0" : "") + month
                + "/" + (day < 10 ? "0" : "") + day);

    }
}
