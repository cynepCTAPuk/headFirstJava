public class LongDivision {
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        final Integer HOURS_PER_DAY  = 24;
        final long NEW_MICROS_PER_DAY = HOURS_PER_DAY * 60 * 60 * 1000 * 1000;
        final long NEW_MILLIS_PER_DAY = HOURS_PER_DAY * 60 * 60 * 1000;

        System.out.println("NEW_MICROS_PER_DAY = " + NEW_MICROS_PER_DAY);
        System.out.println("NEW_MILLIS_PER_DAY = " + NEW_MILLIS_PER_DAY);
        System.out.println("NEW_MICROS_PER_DAY / NEW_MILLIS_PER_DAY = " + NEW_MICROS_PER_DAY / NEW_MILLIS_PER_DAY);
        System.out.format("%,14d%n", 24);
        System.out.format("%,14d = 24 * 60%n", 24 * 60);
        System.out.format("%,14d = 24 * 60 * 60%n", 24 * 60 * 60);
        System.out.format("%,14d = 24 * 60 * 60 * 1000%n", 24 * 60 * 60 * 1000);
        System.out.format("%,14d = 24 * 60 * 60 * 1000 * 1000%n", (24 * 60 * 60 * 1000 * 1000));

        System.out.format("%,14d%n", (1 << 31) - 1);
        System.out.format("%,d%n", (1 << 31));
        int x = 1;
        int y = 1;
        for (int i = 0; i < 32; i++) {
//            System.out.format("%14d = %s%n",(x << i) - y, Integer.toBinaryString((x << i) - y));
        }
    }
}
