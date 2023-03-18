package primitive;

public class TestDecode {
	public static void main(String[] args) {
		String text = "0b11111100101";
		System.out.println(text + " = " + decodeString(text));
		text = "077";
		System.out.println(text + " = " + decodeString(text));
		text = "0xFF";
		System.out.println(text + " = " + decodeString(text));
	}

	private static int decodeString(String text) {
		return text.toLowerCase().startsWith("0b")
				? Integer.parseInt(text.substring(2), 2)
				: Integer.decode(text);
	}
}
