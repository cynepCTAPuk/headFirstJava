package string;

import exceptions.MyException;

public class ReverseInteger {
	public static void main(String[] args) {
		String format = "%,20d%n";
		int n = -1234567890;
		System.out.printf(format, n);
		System.out.printf(format, revers(n));
		System.out.printf(format, (Integer.MAX_VALUE));
		System.out.printf(format, revers(Integer.MAX_VALUE));
	}

	static long revers(long n) {
		if (n < 0) throw new MyException("Number must be positive");
		StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));
		stringBuilder.reverse();
		return Long.parseLong(stringBuilder.toString());
	}
}
