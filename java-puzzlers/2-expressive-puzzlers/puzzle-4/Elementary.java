public class Elementary {
    public static void main(String[] args) {
        System.out.println(12345 + 5432l);

        int a = 12345;
        int b = 54321;
        System.out.format("a = %,8d b = %,8d a + b = %,8d%n", a, b, a + b);

        short c = (short) 12345;
        short d = (short) 54321;
        System.out.format("c = %,8d d = %,8d c + d = %,8d%n", c, d, c + d);

        short sx = 1, sy = 1;
        int ix = 1, iy = 1;
        for (short i = 0; i < 32; i++) {
            if (i < 16) System.out.format("%,8d = %-16s", (short) ((sx << i) - sy),
                    Integer.toBinaryString((sx << i) - sy));
            else System.out.format("%s", " ".repeat(22));
            if (i < 16) System.out.format("%,8d = %s%n", (ix << i) - iy,
                    Integer.toBinaryString((ix << i) - iy));
            else System.out.format("%,13d = %s%n", (ix << i) - iy,
                    Integer.toBinaryString((ix << i) - iy));
        }
        for (int i = 0; i < 32; i++) {
        }
    }
}
