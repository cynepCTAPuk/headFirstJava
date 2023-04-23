package string;

import exceptions.MyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseInteger {
	private static final Logger log = LogManager.getLogger(ReverseInteger.class);

	public static void main(String[] args) {
		String format = "%,20d%n";
		int n = 1234567890;
		System.out.printf(format, n);
		log.info(n);
		System.out.printf(format, reverse(n));
		System.out.printf(format, (Integer.MAX_VALUE));
		System.out.printf(format, reverse(Integer.MAX_VALUE));
	}

	static long reverse(long n) {
		if (n < 0) throw new MyException("Number must be positive");
		StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));
		stringBuilder.reverse();
		return Long.parseLong(stringBuilder.toString());
	}
}
