package oop;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OverloadLong {
	public static void main(String[] args) {
		OverloadLong overloadLong = new OverloadLong();
//		overloadLong.methodA(42);

//		System.out.println(Long.valueOf(42L).equals(42L));
//		System.out.println(new Integer(42) == new Integer(42));
//		System.out.println(Integer.valueOf(42) == 42);
//		System.out.println(Long.valueOf(42L).equals(new Long(42L)));
//		System.out.println(Long.valueOf(42L).equals(42));

//		System.out.println(Integer.valueOf(42).equals(42L));
		String collect = IntStream.range(4, 20)
				.mapToObj(i -> Integer.toHexString((int) (Math.pow(2, i) - 1)))
				.collect(Collectors.joining(", "));
		System.out.println(collect);
	}

	void methodA(Long num) {
		System.out.println(num);
	}
}
