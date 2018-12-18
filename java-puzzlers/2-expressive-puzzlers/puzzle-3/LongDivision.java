public class LongDivision {
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        long micros = MICROS_PER_DAY;
        long millis = MILLIS_PER_DAY;

        Integer integer = (24 * 60 * 60 * 1000 * 1000);

        System.out.println("micros = " + micros);
        System.out.println("millis = " + millis);
        System.out.println("micros / millis = " + micros / millis);
        System.out.format("%,14d%n", 24);
        System.out.format("%,14d = 24 * 60%n", 24 * 60);
        System.out.format("%,14d = 24 * 60 * 60%n", 24 * 60 * 60);
        System.out.format("%,14d = 24 * 60 * 60 * 1000%n", 24 * 60 * 60 * 1000);
        System.out.format("%,14d = 24 * 60 * 60 * 1000 * 1000%n", (24 * 60 * 60 * 1000 * 1000));
        System.out.format("%,14d%n", integer);
        System.out.format("%,14d%n", (1 << 31) - 1);
        System.out.format("%,d%n", (1 << 31));
        int x = 1;
        int y = 1;
        for (int i = 0; i < 32; i++) {
            System.out.format("%14d = %s%n",(x << i) - y, Integer.toBinaryString((x << i) - y));
        }
    }
}
