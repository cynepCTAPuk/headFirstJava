package test;

public class FB {
	public static void main(String[] args) {
//		for (int i = 0; i < 31; i++) System.out.println(fb1(i));
		for (int i = 0; i < 31; i++) System.out.println(fb2(i));
//		for (int i = 0; i < 31; i++) System.out.println(fb3(i));
//		fb4(31);
	}

	public static String fb1(int number) {
		if (number % 3 == 0) {
			if (number % 5 == 0) return "fizzbuzz";
			else return "fizz";
		} else if (number % 5 == 0) return "buzz";
		return String.valueOf(number);
	}

	public static String fb2(int number) {
		if (number % 15 == 0) return "fizzbuzz";
		else if (number % 5 == 0) return "buzz";
		else if (number % 3 == 0) return "fizz";
		return String.valueOf(number);
	}

	private static void fb4(int n) {
		for (int i = 1; i < n; i++) {
			System.out.println(i + (i % 3 == 0 ? "fizz" : "") + (i % 5 == 0 ? "buzz" : ""));
		}
	}

	public static String fb3(int number) {
		StringBuilder sb = new StringBuilder();
		if (number % 3 == 0) sb.append("fizz");
		if (number % 5 == 0) sb.append("buzz");
		return sb.length() == 0 ? String.valueOf(number) : sb.toString();
	}
}
