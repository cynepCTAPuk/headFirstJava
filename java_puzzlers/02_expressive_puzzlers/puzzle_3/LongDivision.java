package puzzle_3;

public class LongDivision {
    public static void main(String[] args) {
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        System.out.printf("MILLIS_PER_DAY = %,11d\n", MILLIS_PER_DAY);
        System.out.printf("MICROS_PER_DAY = %,11d\n", MICROS_PER_DAY);
        System.out.format("MICROS_PER_DAY / MILLIS_PER_DAY = %d\n\n", MICROS_PER_DAY / MILLIS_PER_DAY);

        final long MICROS_PER_DaY = 24L * 60 * 60 * 1000 * 1000;
        System.out.printf("MILLIS_PER_DAY = %,11d\n", MILLIS_PER_DAY);
        System.out.printf("MICROS_PER_DaY = %,11d\n", MICROS_PER_DaY);
        System.out.format("MICROS_PER_DaY / MILLIS_PER_DAY = %d\n\n", MICROS_PER_DaY / MILLIS_PER_DAY);
/*
        int x = 1;
        int y = 0;
        for (int i = 0; i < 32; i++) {
            System.out.format("%,14d = %s%n",(x << i) - y, Integer.toBinaryString((x << i) - y));
        }
*/
    }
}
