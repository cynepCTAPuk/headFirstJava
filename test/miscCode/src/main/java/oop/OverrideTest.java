package oop;

public class OverrideTest {
	public static void main(String[] args) {
		OverrideA b = new OverrideB();
		System.out.println(b.sayWhoIAm());
		System.out.println(b.sayWhoWeAre());
	}
}

class OverrideA {
	public String sayWhoIAm() {
		return "I'm A";
	}

	public static String sayWhoWeAre() {
		return "We are A";
	}
}

class OverrideB extends OverrideA {
	public String sayWhoIAm() {
		return "I'm B";
	}

	public static String sayWhoWeAre() {
		return "We are B";
	}
}


