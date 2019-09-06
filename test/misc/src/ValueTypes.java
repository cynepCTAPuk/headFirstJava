public class ValueTypes {

	public static void main(String[] args) {
		int n = 0;
		for (int i = 33; i < 128; i++) {
			System.out.printf("%3d:%2c ", i, (char) i);
			if (++n % 10 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println();

		short sh = 20;
		int in = 1_000;
		long lg = 12_345_678_901L;
		sh = (short) lg;
		in = (int) lg;

		System.out.printf("%,d -> %,d\n", lg, sh);
		System.out.printf("%,d -> %,d\n", lg, in);

		int x = 5;
		double y = x / 2;
		System.out.println(y);
		System.out.println();

		System.out.printf("%-22s%,26d\n", "Byte.MAX_VALUE", Byte.MAX_VALUE);
		System.out.printf("%-22s%,26d\n", "Short.MAX_VALUE", Short.MAX_VALUE);
		System.out.printf("%-22s%,26d\n", "int.max 1<<31 - 1", (1 << 31)-1);
		System.out.printf("%-22s%,26d\n", "Integer.MAX_VALUE", Integer.MAX_VALUE);
		System.out.printf("%-22s%,26d\n", "Integer.MAX_VALUE + 1", Integer.MAX_VALUE + 1);
		System.out.printf("%-22s%,26d\n", "Integer.MIN_VALUE", Integer.MIN_VALUE);
		System.out.printf("%-22s%,26d\n", "long.max 1<<63 -1", (1L << 63)-1);
		System.out.printf("%-22s%,26d\n", "Long.MAX_VALUE", Long.MAX_VALUE);
		System.out.println();

		boolean a = true;
		boolean b = false;
		System.out.println(a && b);
		System.out.println(a & b);
		System.out.println(a || b);
		System.out.println(!a);
	}
}
