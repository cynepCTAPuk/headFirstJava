package string;

public class ReverseInteger {
	static int revers(int n) {
	StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));
	stringBuilder.reverse();
	return Integer.parseInt(stringBuilder.toString());
	}

	public static void main(String[] args) {
		System.out.println(revers(12345));
	}
}
