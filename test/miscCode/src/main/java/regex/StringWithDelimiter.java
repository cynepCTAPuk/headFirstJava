package regex;
// https://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters

import java.util.Arrays;

public class StringWithDelimiter {
	public static void main(String[] args) {
		String str = "a;b;c;d";
		System.out.println(Arrays.toString(str.split("(?<=;)")));
		System.out.println(Arrays.toString(str.split("(?=;)")));
		System.out.println(Arrays.toString(str.split("((?<=;)|(?=;))")));
	}

    static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
	final String[] aEach = "a;b;c;d".split(String.format(WITH_DELIMITER, ";"));
}
