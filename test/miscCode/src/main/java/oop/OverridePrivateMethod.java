package oop;

import java.util.Arrays;

public class OverridePrivateMethod {
	public static void main(String[] args) {
		Class<? extends Opm2> aClass = Opm2.class;

		System.out.print("-".repeat(30));
		System.out.println("getMethods()");
		Arrays.stream(aClass.getMethods()).forEach(System.out::println);

		System.out.print("-".repeat(30));
		System.out.println("getDeclaredMethods()");
		Arrays.stream(aClass.getDeclaredMethods()).forEach(System.out::println);

		System.out.print("-".repeat(30));
		System.out.println("getEnclosingMethod()");
		System.out.println(aClass.getEnclosingMethod());
	}
}

class Opm1 {
	private void method1() {
		System.out.println("OPM1");
	}
}

class Opm2 extends Opm1 {
	private void method2() {
		System.out.println("OPM2");
	}
	private void method3() {
		System.out.println("OPM2");
	}
}
