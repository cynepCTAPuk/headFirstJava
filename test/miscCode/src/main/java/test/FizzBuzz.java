package test;

public class FizzBuzz {
	public static void main(String[] args) {
		int n = 40;
		for (int i = 1; i <= n; i++) {
			String s = "";
			if (i % 3 == 0) s = s + "fizz";
			if (i % 5 == 0) s = s + "buzz";
			if (s.isEmpty()) s = i + "";
			System.out.print(i == n ? s : s + ", ");
		}
	}
}
