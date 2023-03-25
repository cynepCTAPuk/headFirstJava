package regex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindOps {
	public static void main(String[] args) {
		String str = "  a+b - c    * d / e < f > g >= h <= i == j   ".trim();
		String[] ops = str.split("\\s*[a-zA-Z]+\\s*");
		String[] notops = str.split("\\s*[^a-zA-Z]+\\s*");
		String[] res = new String[ops.length + notops.length - 1];
		for (int i = 0; i < res.length; i++) res[i] = i % 2 == 0 ? notops[i / 2] : ops[i / 2 + 1];

		System.out.println(str);
		System.out.print("-".repeat(30));
		System.out.println(" ops");
		System.out.println(String.join(", ", ops));
		System.out.print("-".repeat(30));
		System.out.println(" notops");
		System.out.println(String.join(", ", notops));
		System.out.print("-".repeat(30));
		System.out.println(" res");
		System.out.println(String.join(" ", res));
		String collect = Arrays.stream(res).map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
		System.out.println(collect);
	}
}
