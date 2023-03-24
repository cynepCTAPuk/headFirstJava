package bigNumber;

import java.math.BigInteger;

public class BigIntegerTest {
	public static void main(String[] args) {
		BigInteger ten = new BigInteger("10");
		BigInteger twenty = new BigInteger("20");
		BigInteger sum = BigInteger.ZERO;
		System.out.println(ten);
		System.out.println(twenty);
		System.out.println(sum);

		sum = sum.add(ten);
		System.out.println(sum);
		sum = sum.add(twenty);
		System.out.println(sum);
	}
}
