package com.example;

public class Main
{

	public static void main(String[] args)
	{
		byte bt = 127; // 0x7F;
		for (int i = 33; i < 128; i++)
		{
			System.out.print((char) i + " ");
		}
		System.out.println((char) (bt - 2));
		short sh = 20;
		int in = 1_000;
		long lg = 12_345_678_901L;
		sh = (short) lg;
		in = (int) lg;

		System.out.printf("%,d -> %,d\n", lg, sh);
		System.out.printf("%,d -> %,d\n", lg, in);

		float fl = 1.0F;
		double db = 1.0; // 1D

		int x = 5;
		double y = x / 2;

		System.out.println(y);

		System.out.printf("%,d\n", Byte.MAX_VALUE);
		System.out.printf("%,d\n", Short.MAX_VALUE);
		System.out.printf("%,d\n", Integer.MAX_VALUE);
		System.out.printf("%,d\n", Integer.MAX_VALUE + 1);
		System.out.printf("%,d\n", Integer.MIN_VALUE);
		System.out.printf("%,d\n", Long.MAX_VALUE);

		boolean a = true;
		boolean b = false;
		boolean c;
		c = a && b; // and
		System.out.println(c);

		c = a & b; // and
		System.out.println(c);

		c = a || b; // OR
		System.out.println(c);

		c = !a; // NOT
		System.out.println(c);
	}
}
