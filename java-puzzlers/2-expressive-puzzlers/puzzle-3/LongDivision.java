import java.math.*;

public class LongDivision {
    public static void main(String[] args) {
        final long MILLIS_PER_DAY_LONG = 24 * 60 * 60 * 1000;
        final long MICROS_PER_DAY_LONG = 24 * 60 * 60 * 1000 * 1000;

        System.out.format("MICROS_PER_DAY_LONG / MILLIS_PER_DAY_LONG = %d%n%n",MICROS_PER_DAY_LONG / MILLIS_PER_DAY_LONG);

        final BigInteger HOURS_PER_DAY = BigInteger.valueOf(24);
        final BigInteger MINUTES_PER_HOUR = BigInteger.valueOf(60);
        final BigInteger SECONDS_PER_MINUTE = BigInteger.valueOf(60);
        final BigInteger THOUSAND = BigInteger.valueOf(1000);
        final BigInteger MILLIS_PER_DAY = HOURS_PER_DAY.multiply(MINUTES_PER_HOUR.multiply(SECONDS_PER_MINUTE.multiply(THOUSAND)));
        final BigInteger MICROS_PER_DAY = HOURS_PER_DAY.multiply(MINUTES_PER_HOUR.multiply(SECONDS_PER_MINUTE.multiply(THOUSAND.multiply(THOUSAND))));

        System.out.format("MICROS_PER_DAY = %,22d%n",MICROS_PER_DAY);
        System.out.format("MILLIS_PER_DAY = %,22d%n",MILLIS_PER_DAY);
        System.out.format("MICROS_PER_DAY / MILLIS_PER_DAY = %,d%n",MICROS_PER_DAY.divide(MILLIS_PER_DAY));

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
