package date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeTest {
    public static void main(String[] args) {
/*
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 9, 1, 0, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 12, 1, 0, 0);
        System.out.println(Duration.between(localDateTime1, localDateTime2).toDays());
        System.out.println(Period.between(localDateTime1.toLocalDate(), localDateTime2.toLocalDate()).getDays());
        System.out.println(Math.pow(2d, 2d));
*/
        Instant now = Instant.now();
        int i = 0;
        System.out.println(++i + ": " + now);
        System.out.println(++i + ": " + now.getEpochSecond());
        System.out.println(++i + ": " + now.toEpochMilli());
        System.out.println(++i + ": " + System.currentTimeMillis());
        System.out.println(++i + ": " + new Date().getTime());

        String dtStr = "2011-03-27 02:13:00 Europe/Moscow";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV");
        System.out.printf("%s%n", dtStr);
        System.out.printf("%s%n", ZonedDateTime.parse(dtStr, dtf).format(dtf));

    }
}
