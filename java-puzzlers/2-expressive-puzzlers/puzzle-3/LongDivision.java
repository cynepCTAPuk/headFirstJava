import java.math.*;

public class LongDivision {
    public static void main(String[] args) {
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;

//        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        final BigInteger HOURS_PER_DAY = BigInteger.valueOf(24);
        final BigInteger MINUTES_PER_HOUR = BigInteger.valueOf(60);
        final BigInteger SECONDS_PER_MINUTE = BigInteger.valueOf(60);
        final BigInteger THOUSAND = BigInteger.valueOf(1000);
        System.out.format("%,14d%n",HOURS_PER_DAY.multiply(MINUTES_PER_HOUR.multiply(SECONDS_PER_MINUTE.multiply(THOUSAND.multiply(THOUSAND)))));
//        final BigInteger NEW_MILLIS_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE * THOUSAND;
//        final BigInteger NEW_MICROS_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE * THOUSAND * THOUSAND;

//        System.out.format("NEW_MILLIS_PER_DAY = %,14d%n", NEW_MILLIS_PER_DAY);
//        System.out.format("NEW_MICROS_PER_DAY = %,14d%n", NEW_MICROS_PER_DAY);
//        System.out.println("NEW_MICROS_PER_DAY / NEW_MILLIS_PER_DAY = " + NEW_MICROS_PER_DAY / NEW_MILLIS_PER_DAY);
        System.out.format("%,14d%n", 24);
        System.out.format("%,14d = 24 * 60%n", 24 * 60);
        System.out.format("%,14d = 24 * 60 * 60%n", 24 * 60 * 60);
        System.out.format("%,14d = 24 * 60 * 60 * 1000%n", 24 * 60 * 60 * 1000);
        System.out.format("%,14d = 24 * 60 * 60 * 1000 * 1000%n", (24 * 60 * 60 * 1000 * 1000));

//        System.out.format("%,14d%n", (1 << 31) - 1);
//        System.out.format("%,d%n", (1 << 31));
        int x = 1;
        int y = 1;
        for (int i = 0; i < 32; i++) {
//            System.out.format("%14d = %s%n",(x << i) - y, BigInteger.toBinaryString((x << i) - y));
        }
    }
}
