package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest2 {
	public static void main(String[] args) {
		String str = "abcd";
		System.out.println("String=" + str);
		String pattern = "[ab]";
		extracted(str, pattern);
		pattern = "[^b]";
		extracted(str, pattern);
	}

	private static void extracted(String str, String pattern) {
		System.out.println("---pattern=" + pattern);
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		while (m.find()) System.out.println(m.group() + " " + m.start() + ":" + m.end());
	}
}
