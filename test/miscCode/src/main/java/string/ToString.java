package string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ToString {
	public static void main(String[] args) {
		int i = 0;

		System.out.println(++i + " " + "-".repeat(30));
		Character[] characters = {'a', 'b', 'c'};
		System.out.println(Arrays.toString(characters));
		System.out.println(Arrays.asList(characters));

		System.out.println(++i + " " + "-".repeat(30));
		char[] chars = {'a', 'b', 'c'};
		System.out.println(chars);
		String[] strings = {"a", "b", "c"};
		System.out.println(String.join(", ", strings));
		System.out.println(Arrays.stream(strings).collect(Collectors.joining(", ", "{", "}")));

		System.out.println(++i + " " + "-".repeat(30));
		String str = null;
		System.out.println(str);
		Double dbl = null;
		System.out.println(dbl);
	}
}
