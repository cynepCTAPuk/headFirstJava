package com.example;

public class Main
{

	public static void main(String[] args)
	{
		byte bt = 127; // 0x1F
		short sh = 20;
		int in = 1_000;
		long lg = 12_345_678_901L;
		sh = (short) lg;
		in = (int) lg;

		System.out.printf("%,d -> %,d\n", lg, sh);
		System.out.printf("%,d -> %,d", lg, in);
		
		float fl = 1.0F;
		double dbl = 1.0;
		

	}

}
